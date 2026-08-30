package com.example.andegym

import android.app.Application
import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import androidx.room3.Room
import com.example.andegym.data.local.AppDatabase
import com.example.andegym.data.local.WorkoutDao
import com.example.andegym.data.repository.WorkoutRepository
private val Context.userProgressDataStore by preferencesDataStore("user_progress")
class App: Application(){
//    val database by lazy{
//        Room.databaseBuilder(this, AppDatabase::class.java,"gum.db").build()
//    }
//    val dao by lazy{
//        database.workoutDao()
//    }
//    val repository by lazy{
//        WorkoutRepository(dao)
//    }
    val dataStore by lazy{
        userProgressDataStore
}
}