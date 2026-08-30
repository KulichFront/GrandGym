package com.example.andegym.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class AchievementManager(private val dataStore: DataStore<Preferences>,private val userProgressManager: UserProgressManager) {
    companion object {
        val ACH_FIRST_WORKOUT = booleanPreferencesKey("ach_first_workout")
        val ACH_EARLY_BIRD = booleanPreferencesKey("ach_early_bird")
        val ACH_THREE_WORKOUTS = booleanPreferencesKey("ach_three_workout")
        val ACH_HEAVY_LIFTER = booleanPreferencesKey("ach_heavy_lifter")
        val ACH_TEN_WORKOUTS = booleanPreferencesKey("ach_ten_workout")
    }

    val workoutCountFlow: Flow<Int> = dataStore.data.map {
        preferences -> preferences[UserProgressManager.WORKOUT_COUNT_KEY]?:0
    }

    val firstWorkoutFlow: Flow<Boolean > = dataStore.data.map{
        preferences-> preferences[ACH_FIRST_WORKOUT]?:false
    }

    val threeWorkoutFlow:Flow<Boolean> = dataStore.data.map{
        preferences -> preferences[ACH_THREE_WORKOUTS]?:false
    }

    val tenWorkoutFlow:Flow<Boolean> = dataStore.data.map{
            preferences -> preferences[ACH_TEN_WORKOUTS]?:false
    }

    val earlyBirdFlow:Flow<Boolean> = dataStore.data.map{
            preferences -> preferences[ACH_EARLY_BIRD]?:false
    }

    val heavyLifterFlow:Flow<Boolean> = dataStore.data.map{
            preferences -> preferences[ACH_HEAVY_LIFTER]?:false
    }

    suspend fun  grandAchievement(key: Preferences.Key<Boolean>){
        dataStore.edit {preferences ->
            if(preferences[key]!=true){
                preferences.toMutablePreferences().apply {
                    this[key]=true
                }
                userProgressManager.addXp(100)
            }
            else{
                preferences
            }
        }
    }

    suspend fun checkFirstWorkout(){
        if(workoutCountFlow.first()>=1){
            grandAchievement(ACH_FIRST_WORKOUT)
        }
    }

    suspend fun checkThreeWorkout(){
        if(workoutCountFlow.first()>=3){
            grandAchievement(ACH_THREE_WORKOUTS)
        }
    }

    suspend fun checkTenWorkout(){
        if(workoutCountFlow.first()>=10){
            grandAchievement(ACH_TEN_WORKOUTS)
        }
    }

    suspend fun checkHeavyLifter(weight:Float){
        TODO()
    }

    suspend fun checkEarlyBird(hour:Int){
        if(hour<=9 ){
            grandAchievement(ACH_EARLY_BIRD)
        }
    }
}