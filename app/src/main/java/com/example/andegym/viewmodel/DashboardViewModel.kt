package com.example.andegym.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel

import com.example.andegym.data.model.ExercisePlan
import com.example.andegym.data.parser.TrainingPlanParser

import com.example.andegym.data.repository.WorkoutRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.LocalDate


class DashboardViewModel(application: Application): AndroidViewModel(application){
    private val _name=MutableStateFlow("Кирилл")
    val name: StateFlow<String> =(_name)


    private val _nickname= MutableStateFlow("")
    val nickname: StateFlow<String> = _nickname
    private val _percentages=MutableStateFlow(87)
    val percentages: StateFlow<Int> = (_percentages)

    private val _todayPlan=MutableStateFlow<List<ExercisePlan>>(emptyList())

        fun loadPlan(){
            val context=getApplication<Application>()
            val today= LocalDate.now().dayOfWeek.name
            val days= TrainingPlanParser(context)
            val plan=days.firstOrNull{it.day==today}?.exercise?:emptyList()
            _todayPlan.value=plan
        }
    init{
        loadPlan()
    }
    val todayPlan: StateFlow<List<ExercisePlan>> = _todayPlan


    init{
        val uid= FirebaseAuth.getInstance().currentUser?.uid
        if(uid!=null){
            FirebaseFirestore.getInstance()
                .collection("users")
                .document(uid)
                .get()
                .addOnSuccessListener { doc ->
                    _nickname.value = doc.getString("nickname") ?: "Пользователь"
                }

        }
    }
}
