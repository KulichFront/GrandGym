package com.example.andegym.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FriendProfileViewModel(val uid:String): ViewModel() {
    private val _nickname = MutableStateFlow("Пользователь")
    val nickname: StateFlow<String> = _nickname

    private val _xp = MutableStateFlow(0)
    val xp: StateFlow<Int> = _xp

    private val _level = MutableStateFlow(1)
    val level: StateFlow<Int> = _level

    private val _workoutCount = MutableStateFlow(0)
    val workoutCount: StateFlow<Int> = _workoutCount

    private val _totalVolume = MutableStateFlow(0)
    val totalVolume: StateFlow<Int> = _totalVolume

    private val _isPublic = MutableStateFlow(true)
    val isPublic: StateFlow<Boolean> = _isPublic

    private val _threeWorkout=MutableStateFlow(false)
    val threeWorkout: StateFlow<Boolean> =_threeWorkout

    private val _tenWorkout=MutableStateFlow(false)
    val tenWorkout: StateFlow<Boolean> =_tenWorkout

    private val _earlyBird=MutableStateFlow(false)
    val earlyBird: StateFlow<Boolean> =_earlyBird

    private val _firstWorkout=MutableStateFlow(false)
    val firstWorkout: StateFlow<Boolean> =_firstWorkout

    private val _heavyLifter=MutableStateFlow(false)
    val heavyLifter: StateFlow<Boolean> =_heavyLifter


    init{
        val firestore= FirebaseFirestore.getInstance()

        firestore.collection("users").document(uid).get().addOnSuccessListener {
            document->
            _nickname.value=document.getString("nickname")?:""
            _xp.value=document.getLong("xp")?.toInt()?: 0
            _level.value=document.getLong("level")?.toInt()?:1
            _isPublic.value = document.getBoolean("isPublic") ?: true
            if(isPublic.value){
                _firstWorkout.value = document.getBoolean("ach_first_workout") ?: false

                _threeWorkout.value = document.getBoolean("ach_three_workout") ?: false

                _tenWorkout.value = document.getBoolean("ach_ten_workout") ?: false

                _earlyBird.value = document.getBoolean("ach_early_bird") ?: false

                _heavyLifter.value = document.getBoolean("ach_heavy_lifter") ?: false
            }

    }

}
}