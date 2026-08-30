package com.example.andegym.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class WorkoutRecord(
    @PrimaryKey(autoGenerate = true) val id:Long=0,
    val date :Long,
    val totalVolume:Int,
    val difficulty: String
    )