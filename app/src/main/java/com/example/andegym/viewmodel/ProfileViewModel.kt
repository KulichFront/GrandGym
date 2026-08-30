package com.example.andegym.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.andegym.App
import com.example.andegym.data.AchievementManager
import com.example.andegym.data.UserProgressManager

class ProfileViewModel(application: Application): AndroidViewModel(application) {
    val app= application as App
    val dataStore=app.dataStore
    private val progressUser= UserProgressManager(dataStore)

    val xpFlow=progressUser.xpFlow
    fun getlevel(xp:Int):Int=progressUser.getLevel(xp)

    val achievementManager= AchievementManager(dataStore,progressUser)

    val firstWorkoutFlow=achievementManager.firstWorkoutFlow
    val threeWorkoutFlow=achievementManager.threeWorkoutFlow
    val tenWorkoutFlow=achievementManager.tenWorkoutFlow
    val earlyBirdFlow=achievementManager.earlyBirdFlow
    val heavyLifterFlow=achievementManager.heavyLifterFlow
}