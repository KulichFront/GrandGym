package com.example.andegym.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [WorkoutRecord::class,
    ExerciseRecord::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun workoutDao():WorkoutDao
}