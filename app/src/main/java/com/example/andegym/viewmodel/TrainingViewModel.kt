package com.example.andegym.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.andegym.App
import com.example.andegym.data.AchievementManager
import com.example.andegym.data.UserProgressManager
import com.example.andegym.data.model.ExercisePlan
import com.example.andegym.data.parser.TrainingPlanParser
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime

class TrainingViewModel(application: Application): AndroidViewModel(application){

    val app=application as App
    val dataStore=app.dataStore
    val userProgressManager= UserProgressManager(dataStore)
    val achiementManager= AchievementManager(dataStore,userProgressManager)
    private val _isRunning= MutableStateFlow(false)
    val isRunning: StateFlow<Boolean> = _isRunning

    private val _time =MutableStateFlow(180L)
    val time: StateFlow< Long> =_time

    private val _weight=MutableStateFlow(50F)
    val weight: StateFlow<Float> = _weight


    private val _currentExercise=MutableStateFlow<ExercisePlan?>(null)
    val currentExercise: StateFlow<ExercisePlan?> = _currentExercise

    private val _isWorkoutFinished=MutableStateFlow(false)
    val isWorkoutFinished: StateFlow<Boolean> = _isWorkoutFinished


    fun increaseWeight(){
        _weight.value+=2.5f
    }

    fun decreaseWeight(){
        if(_weight.value<=2.5f){
            _weight.value=2.5f
        }
        else{
            _weight.value-=2.5f
        }
    }

    fun startRest(){
        if(!_isRunning.value){
            _isRunning.value=true
            viewModelScope.launch {
                while(_time.value>0 && _isRunning.value==true){
                    _time.value-=1
                    delay(1000)
                }
                if(_time.value <= 0){
                    onFinishedRest()
                }
            }


        }
    }

    fun onFinishedRest(){
        _isRunning.value=false
        _time.value=180
        nextExercise()
    }

    fun pauseRest(){
        if(_isRunning.value){
            _isRunning.value=false
        }
    }

    fun resumeRest(){
        startRest()
    }


    private val _todayPlan=MutableStateFlow<List<ExercisePlan>>(emptyList())
    fun loadPlan(){
        val context=getApplication<Application>()
        val today= LocalDate.now().dayOfWeek.name
        val days= TrainingPlanParser(context)
        val plan=days.firstOrNull{it.day==today}?.exercise?:emptyList()
        _todayPlan.value=plan
        _currentExercise.value=plan.firstOrNull()
    }
    init{
        loadPlan()
    }
    val todayPlan: StateFlow<List<ExercisePlan>> = _todayPlan

    private val _currentIndex=MutableStateFlow(0)
    val currentIndex : StateFlow<Int> = _currentIndex

    fun nextExercise(){
        if(_currentIndex.value+1<_todayPlan.value.size){
            _currentIndex.value+=1
            _currentExercise.value=_todayPlan.value[_currentIndex.value]
        }
        else{
            _isWorkoutFinished.value=true
        }
    }


    fun finishCurrentExercise(){
        if(_currentIndex.value+1>=_todayPlan.value.size){
            _isWorkoutFinished.value=true
            viewModelScope.launch {
                userProgressManager.completeWorkout()
                userProgressManager.incrementWorkoutCount()
                achiementManager.checkFirstWorkout()
                achiementManager.checkThreeWorkout()
                achiementManager.checkTenWorkout()
                achiementManager.checkEarlyBird(LocalTime.now().hour)

            }
        }
        else{
            startRest()
        }
    }
}