package com.example.andegym.data.local

import androidx.room3.Database
import androidx.room3.RoomDatabase

@Database(entities = [WorkoutRecord::class,
    ExerciseRecord::class], version = 1)
abstract class AppDatabase:RoomDatabase(){
    abstract fun workoutDao():WorkoutDao
}