package com.example.andegym.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ExerciseRecord(
    @PrimaryKey(autoGenerate = true) val id:Long=0,
    val workoutId: Long,
    val name: String,
    val weight: Float,
    val reps:Int,
    val sets:Int,
    )