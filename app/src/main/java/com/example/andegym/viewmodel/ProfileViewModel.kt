package com.example.andegym.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.andegym.App
import com.example.andegym.data.model.toUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application): AndroidViewModel(application) {
    val app= application as App

    private val progressUser= app.userProgress

    private val _nickname= MutableStateFlow("Пользователь")
    val nickname: StateFlow<String> = _nickname

    private val _workoutCount = MutableStateFlow(0)
    val workoutCount: StateFlow<Int> = _workoutCount

    private val _totalVolume = MutableStateFlow(0)
    val totalVolume: StateFlow<Int> = _totalVolume

    val xpFlow=progressUser.xpFlow

    fun getlevel(xp:Int):Int=progressUser.getlevel(xp)

    val achievementManager= app.achievement

    val firstWorkoutFlow=achievementManager.firstWorkoutFlow
    val threeWorkoutFlow=achievementManager.threeWorkoutFlow
    val tenWorkoutFlow=achievementManager.tenWorkoutFlow
    val earlyBirdFlow=achievementManager.earlyBirdFlow

    val heavyLifter=achievementManager.heavyLifter

    private val _isPublic = MutableStateFlow(true)
    val isPublic: StateFlow<Boolean> = _isPublic

    fun togglePrivacy(){
        val uid= FirebaseAuth.getInstance().currentUser?.uid
        if(uid!=null){
            val newValue = !_isPublic.value
            FirebaseFirestore
                .getInstance()
                .collection("users")
                .document(uid)
                .update("isPublic",newValue)
            _isPublic.value = newValue
        }
    }

    init{

        val uid= FirebaseAuth.getInstance().currentUser?.uid
        if(uid!=null){
            FirebaseFirestore.getInstance()
                .collection("users")
                .document(uid)
                .get()
                .addOnSuccessListener { doc ->
                    if (doc.exists()) {
                        val user = doc.toUser()
                        _nickname.value = user.nickname.ifBlank { "Пользователь" }
                        _isPublic.value = user.isPublic


                    }
                }

        }
        viewModelScope.launch {
            _workoutCount.value = app.repository.countsGum()
            _totalVolume.value = app.repository.totalVolume()

        }


    }
}