package com.example.andegym.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate


class UserProgressManager(private  val dataStore: DataStore<Preferences>){
    companion object{
        val XP_KEY= intPreferencesKey("xp")
        val LAST_WORKOUT_DAY_KEY= stringPreferencesKey("last_day")
        val WORKOUT_COUNT_KEY=intPreferencesKey("workout_count_key")
    }

    val xpFlow: Flow<Int> = dataStore.data.map {
        preferences -> preferences[XP_KEY]?:0
    }

    suspend fun completeWorkout(){
        val today= LocalDate.now().toString()
        dataStore.edit { preferences ->
            if(today!=preferences[LAST_WORKOUT_DAY_KEY]){
                val currentXP = preferences[XP_KEY] ?: 0
                val newXP = currentXP + 10
                preferences.toMutablePreferences().apply {
                    this[XP_KEY]=newXP
                    this[LAST_WORKOUT_DAY_KEY]=today
                }
            }
            else{
                preferences
            }

        }
    }
    fun  getLevel(xp:Int):Int{
        return (xp / 100) + 1
    }
    suspend fun addXp(ammount:Int){
        dataStore.edit { preferences ->

            val currentXP = preferences[XP_KEY] ?: 0
            val newXp=currentXP+ammount
            preferences.toMutablePreferences().apply {
                this[XP_KEY]=newXp
            }

        }
    }

    suspend fun incrementWorkoutCount(){
        dataStore.edit { preferences ->
            val currentCount=preferences[WORKOUT_COUNT_KEY] ?:0
            val newCount=currentCount+1
            preferences.toMutablePreferences().apply {
                this[WORKOUT_COUNT_KEY]=newCount
            }
        }
    }
}