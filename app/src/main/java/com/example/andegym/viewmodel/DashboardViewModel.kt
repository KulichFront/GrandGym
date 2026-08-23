package com.example.andegym.viewmodel

import androidx.lifecycle.ViewModel
import com.example.andegym.data.model.ExercisePlan

import com.example.andegym.data.repository.WorkoutRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


val Gym1= ExercisePlan("жим",3,10,13.0)
val Gym2= ExercisePlan("жим2",3,10,13.0)
val Gym3= ExercisePlan("жим3",3,10,13.0)


class DashboardViewModel(private val repository: WorkoutRepository): ViewModel(){
    private val _name=MutableStateFlow("Кирилл")
    val name: StateFlow<String> =(_name)

    private val _percentages=MutableStateFlow(87)
    val percentages: StateFlow<Int> = (_percentages)

    private val _todayPlan=MutableStateFlow(listOf(Gym1,Gym2,Gym3))
    val todayPlan: StateFlow<List<ExercisePlan>> = _todayPlan

}
