package com.example.andegym.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface  WorkoutDao{
    @Query("SELECT * FROM WorkoutRecord ORDER BY date DESC LIMIT 1")
    suspend fun lastGym(): WorkoutRecord

    @Query("SELECT COUNT(*) FROM WorkoutRecord")
    suspend fun countGym():Int

    @Query("SELECT SUM(totalVolume) FROM WorkoutRecord")
    suspend fun totalVolume(): Int
//
//    @Query("SELECT * FROM ExerciseRecord WHERE name = :name ORDER BY date ASC")
//    fun progressTrainy(name: String):List<ExerciseRecord>


    @Insert
    suspend fun addWorkout(workout: WorkoutRecord)

    @Insert
    suspend fun addExersises(exercises: List<ExerciseRecord>)


}


