package com.example.andegym.data.model

data class User (
    val userId:String,
    val nickname:String,
    val level :Int,
    val xp:Int,
    val isPublic: Boolean,
    val totalVolume:Int,
    val workoutCount:Int,
    val friends: List<String>
)