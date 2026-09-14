package com.example.andegym.data.repository

import com.example.andegym.data.local.ExerciseRecord
import com.example.andegym.data.local.WorkoutDao
import com.example.andegym.data.local.WorkoutRecord

class WorkoutRepository(private  val dao: WorkoutDao) {

    suspend fun addWorkout(work: WorkoutRecord){
        dao.addWorkout(  work)
    }

    suspend fun addExercises(exercise: List<ExerciseRecord>){
        dao.addExersises(exercise)
    }

    suspend fun getLastGym(): WorkoutRecord{
        return dao.lastGym()

    }

    suspend fun countsGum():Int{
        return dao.countGym()
    }

    suspend fun totalVolume():Int {
        return dao.totalVolume()
    }
//
//    fun progressTrainy(name: String):List<ExerciseRecord>{
//        return dao.progressTrainy(name)
//    }
}