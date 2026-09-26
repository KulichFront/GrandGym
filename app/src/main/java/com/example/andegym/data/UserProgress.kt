package com.example.andegym.data

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class UserProgress(context: Context){
    private val userPrefs=UserPrefs(context)

    private val firestore= FirebaseFirestore.getInstance()
    val xpFlow: Flow <Int> = userPrefs.xp
    val countDayFlow:Flow<Int> =userPrefs.count_day


    fun completeWorkout() {
        val today= LocalDate.now().toString()
       val currentXp=userPrefs.get_XP()
        val new_Xp=currentXp+10
        userPrefs.setXP(new_Xp)
        val currentDayCount=userPrefs.getWorkoutCount()
        val newWorkoutCount=currentDayCount+1
        userPrefs.setWorkoutCount(newWorkoutCount)
        userPrefs.setLastDay(today)
        syncXpToFirestore()
    }

     fun addXp(amount:Int){
        val curentXp=userPrefs.get_XP()
        val newXp=curentXp+amount
        userPrefs.setXP(newXp)
         syncXpToFirestore()
    }



    fun getlevel(xp:Int):Int{
        return (xp/100)+1
    }

    fun getWorkoutCount():Int{
        return userPrefs.getWorkoutCount()
    }
    fun clearData(){
        userPrefs.clearData()
    }


    fun syncXpToFirestore(){
        val uid= FirebaseAuth.getInstance().currentUser?.uid
        if(uid!=null){
            firestore
                .collection("users")
                .document(uid)
                .update(mapOf(
                    "xp" to userPrefs.get_XP(),
                    "level" to getlevel(userPrefs.get_XP())
                ))
        }
    }

    fun setXPFromFirestore(xp:Int){
        userPrefs.setXP(xp)
    }
}