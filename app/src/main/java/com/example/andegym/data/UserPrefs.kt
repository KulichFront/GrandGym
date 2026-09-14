package com.example.andegym.data

import android.content.Context
import androidx.compose.ui.input.key.Key
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class UserPrefs(context: Context) {
    private val prefs=context.getSharedPreferences("user_progress",Context.MODE_PRIVATE)

    companion object{
        const val XP_KEY="xp"
        const val WORKOUT_COUNT_KEY="count_day"
        const val LAST_DAY_KEY="last_day"
    }

    private  val _xp= MutableStateFlow(prefs.getInt(XP_KEY,0))
    val xp: StateFlow<Int> =_xp

    private val _count_day=MutableStateFlow(prefs.getInt(WORKOUT_COUNT_KEY,0))
    val count_day : StateFlow<Int> =_count_day


    fun get_XP():Int{
        return prefs.getInt(XP_KEY,0)
    }

    fun setXP(value:Int){
        prefs.edit().putInt(XP_KEY,value).apply()
        _xp.value=value
    }

    fun getWorkoutCount():Int{
        return prefs.getInt(WORKOUT_COUNT_KEY,0)
    }

    fun  setWorkoutCount(value :Int){
        prefs.edit().putInt(WORKOUT_COUNT_KEY,value).apply()
        _count_day.value=value
    }

    fun getLastDay(): String{
        return prefs.getString(LAST_DAY_KEY,"").toString()
    }

    fun setLastDay(value: String){
        prefs.edit().putString(LAST_DAY_KEY,value).apply()
    }
}