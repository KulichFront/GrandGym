package com.example.andegym

import android.app.Application
import androidx.room.Room
import com.example.andegym.data.Achievement
import com.example.andegym.data.UserProgress
import com.example.andegym.data.local.AppDatabase
import com.example.andegym.data.model.toUser
import com.example.andegym.data.repository.WorkoutRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class App: Application(){
    val database: AppDatabase by lazy{
        Room.databaseBuilder(this, AppDatabase::class.java,"gum.db").build()
    }
    val dao by lazy{
        database.workoutDao()
    }
    val repository by lazy{
        WorkoutRepository(dao)
    }
    val userProgress by lazy {
        UserProgress(this)
    }

    val achievement by lazy {
        Achievement(this, userProgress)   // ← переиспользует userProgress
    }

    fun logout(){
        userProgress.clearData()
        achievement.clearAchievement()
        FirebaseAuth.getInstance().signOut()
    }

    fun pullFromFirestore(Done:()->Unit={}){
        val uid= FirebaseAuth.getInstance().currentUser?.uid
        if(uid==null){
            Done()
            return
        }
        FirebaseFirestore.getInstance()
            .collection("users")
            .document(uid)
            .get()
            .addOnSuccessListener { doc->
                if(doc.exists()){
                    val user=doc.toUser()
                    userProgress.setXPFromFirestore(user.xp)
                    achievement.setFromUser(user)
                }
                Done()
            }
            .addOnFailureListener {
                Done()

            }
    }
}
