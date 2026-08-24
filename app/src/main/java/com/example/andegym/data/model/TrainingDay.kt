package com.example.andegym.data.model

import kotlinx.serialization.Serializable

@Serializable
data class TrainingDay(
    val day:String,
    val exercise: List<ExercisePlan>
)