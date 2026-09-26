package com.example.andegym.viewmodel

import androidx.lifecycle.ViewModel
import com.example.andegym.data.model.toUser
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
            val user = document.toUser()
            _nickname.value = user.nickname.ifBlank { "Пользователь" }
            _xp.value = user.xp
            _level.value = user.level
            _isPublic.value = user.isPublic
            if(isPublic.value){
                _firstWorkout.value = user.achFirstWorkout
                _threeWorkout.value = user.achThreeWorkouts
                _tenWorkout.value = user.achTenWorkouts
                _earlyBird.value = user.achEarlyBird
                _heavyLifter.value = user.achHeavyLifter
            }

    }

}
}