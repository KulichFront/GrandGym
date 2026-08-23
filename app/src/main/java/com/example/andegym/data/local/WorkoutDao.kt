package com.example.andegym.data.local

import androidx.room3.Dao
import androidx.room3.Database
import androidx.room3.Insert
import androidx.room3.Query

@Dao
interface  WorkoutDao{
    @Query("SELECT * FROM WorkoutRecord ORDER BY date DESC LIMIT 1")
    fun lastGym(): WorkoutRecord

    @Query("SELECT COUNT(*) FROM WorkoutRecord")
    fun countGym():Int

    @Query("SELECT SUM(totalVolume) FROM WorkoutRecord")
    fun totalVolume(): Int

    @Query("SELECT * FROM ExerciseRecord WHERE name = :name ORDER BY date ASC")
    fun progressTrainy(name: String):List<ExerciseRecord>


    @Insert
    fun addWorkout(workout: WorkoutRecord)

    @Insert
    fun addExersises(exercises: List<ExerciseRecord>)


}


