package com.example.andegym.data.model

import com.google.firebase.firestore.DocumentSnapshot
fun DocumentSnapshot.toUser():User=User(
    userId = id,
    nickname = getString("nickname")?:"",
    level= getLong("level")?.toInt() ?: 1,
    xp=getLong("xp")?.toInt()?:0,
    isPublic = getBoolean("isPublic")?:true,
    friends=(get("friends") as? List<*>)?.filterIsInstance<String>() ?: emptyList(),
    achFirstWorkout = getBoolean("ach_first_workout")?:false,
    achEarlyBird = getBoolean("ach_early_bird")?:false,
    achThreeWorkouts = getBoolean("ach_three_workouts")?:false,
    achTenWorkouts = getBoolean("ach_ten_workouts")?:false,
    achHeavyLifter = getBoolean("ach_heavy_lifter")?:false

)
fun User.toMap():Map<String, Any> =mapOf(
    "nickname" to nickname,
    "level" to level,
    "xp" to xp,
    "isPublic" to isPublic,
    "friends" to friends,
    "ach_first_workout" to achFirstWorkout,
    "ach_early_bird" to achEarlyBird,
    "ach_three_workouts" to achThreeWorkouts,
    "ach_ten_workouts" to achTenWorkouts,
    "ach_heavy_lifter" to achHeavyLifter
)