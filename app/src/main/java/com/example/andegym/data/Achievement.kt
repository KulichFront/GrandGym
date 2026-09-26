package com.example.andegym.data

import android.content.Context
import com.example.andegym.data.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
class Achievement(context: Context, private val userProgress: UserProgress){

    private  val achievement_prefs=context.getSharedPreferences("achievement_prefs",Context.MODE_PRIVATE)
    companion object {
        val ACH_FIRST_WORKOUT = "ach_first_workout"
        val ACH_EARLY_BIRD = "ach_early_bird"
        val ACH_THREE_WORKOUTS ="ach_three_workouts"
        val ACH_HEAVY_LIFTER = "ach_heavy_lifter"
        val ACH_TEN_WORKOUTS = "ach_ten_workouts"
    }

    val _firstWorkoutFlow= MutableStateFlow(achievement_prefs.getBoolean(ACH_FIRST_WORKOUT,false))
    val firstWorkoutFlow: StateFlow<Boolean> =_firstWorkoutFlow

    val _threeWorkoutFlow=MutableStateFlow(achievement_prefs.getBoolean(ACH_THREE_WORKOUTS,false))
    val threeWorkoutFlow: StateFlow<Boolean> = _threeWorkoutFlow

    val _tenWorkoutFlow= MutableStateFlow(achievement_prefs.getBoolean(ACH_TEN_WORKOUTS,false))
    val tenWorkoutFlow: StateFlow<Boolean> =_tenWorkoutFlow

    val _earlyBirdFlow=MutableStateFlow(achievement_prefs.getBoolean(ACH_EARLY_BIRD,false))
    val earlyBirdFlow :StateFlow<Boolean> =_earlyBirdFlow

    val _heavyLifter=MutableStateFlow(achievement_prefs.getBoolean(ACH_HEAVY_LIFTER,false))
    val heavyLifter: StateFlow<Boolean> =_heavyLifter

    private val firestore= FirebaseFirestore.getInstance()

     fun  grandAchievement(key: String){
        if(!achievement_prefs.getBoolean(key,false)){
            achievement_prefs.edit().putBoolean(key,true).apply()
            userProgress.addXp(100)
            when(key){
                ACH_FIRST_WORKOUT->_firstWorkoutFlow.value=true
                ACH_THREE_WORKOUTS->_threeWorkoutFlow.value=true
                ACH_TEN_WORKOUTS->_tenWorkoutFlow.value=true
                ACH_EARLY_BIRD->_earlyBirdFlow.value=true
                ACH_HEAVY_LIFTER->_heavyLifter.value=true
            }

            val myId= FirebaseAuth.getInstance().currentUser?.uid
            if(myId!=null){
                firestore.collection("users").document(myId)
                    .update(key,true)
            }
        }
    }

     fun checkFirstWorkout(){
        if(userProgress.getWorkoutCount()>=1){
            grandAchievement(Achievement.Companion.ACH_FIRST_WORKOUT)
        }
    }

     fun checkThreeWorkout(){
        if(userProgress.getWorkoutCount()>=3){
            grandAchievement(Achievement.Companion.ACH_THREE_WORKOUTS)
        }
    }

   fun checkTenWorkout(){
        if(userProgress.getWorkoutCount()>=10){
            grandAchievement(Achievement.Companion.ACH_TEN_WORKOUTS)
        }
    }

    fun checkHeavyLifter(weight:Float){
        TODO()
    }

     fun checkEarlyBird(hour:Int){
        if(hour<=9 ){
            grandAchievement(Achievement.Companion.ACH_EARLY_BIRD)
        }
    }

    fun clearAchievement(){
        achievement_prefs.edit().clear().apply()
        _firstWorkoutFlow.value = false
        _threeWorkoutFlow.value = false
        _tenWorkoutFlow.value = false
        _earlyBirdFlow.value = false
        _heavyLifter.value = false
    }

    fun setFromUser(user: User){
        achievement_prefs.edit()
            .putBoolean(ACH_FIRST_WORKOUT,user.achFirstWorkout)
            .putBoolean(ACH_EARLY_BIRD,user.achEarlyBird)
            .putBoolean(ACH_THREE_WORKOUTS,user.achThreeWorkouts)
            .putBoolean(ACH_TEN_WORKOUTS,user.achTenWorkouts)
            .putBoolean(ACH_HEAVY_LIFTER,user.achHeavyLifter)
            .apply()
        _firstWorkoutFlow.value = user.achFirstWorkout
        _threeWorkoutFlow.value = user.achThreeWorkouts
        _tenWorkoutFlow.value = user.achTenWorkouts
        _earlyBirdFlow.value = user.achEarlyBird
        _heavyLifter.value = user.achHeavyLifter
    }


}