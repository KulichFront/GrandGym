package com.example.andegym.data.model

data class User (
    val userId:String,
    val nickname:String,
    val level :Int,
    val xp:Int,
    val isPublic: Boolean,
    val friends: List<String>,
    val achFirstWorkout: Boolean = false,
    val achEarlyBird: Boolean = false,
    val achThreeWorkouts: Boolean = false,
    val achTenWorkouts: Boolean = false,
    val achHeavyLifter: Boolean = false
)