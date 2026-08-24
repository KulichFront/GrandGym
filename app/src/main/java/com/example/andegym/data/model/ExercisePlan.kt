package com.example.andegym.data.model

import kotlinx.serialization.Serializable


@Serializable
data class ExercisePlan(
    val name: String,
    val sets:Int,
    val reps:Int,
    val weight: Double,
)