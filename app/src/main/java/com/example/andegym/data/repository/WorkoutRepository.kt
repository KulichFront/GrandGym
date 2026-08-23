package com.example.andegym.data.repository

import com.example.andegym.data.local.ExerciseRecord
import com.example.andegym.data.local.WorkoutDao
import com.example.andegym.data.local.WorkoutRecord

class WorkoutRepository(private  val dao: WorkoutDao) {

    fun addWorkout(work: WorkoutRecord){
        dao.addWorkout(  work)
    }

    fun addExercises(exercise: List<ExerciseRecord>){
        dao.addExersises(exercise)
    }

    fun getLastGym(): WorkoutRecord{
        return dao.lastGym()

    }

    fun countsGum():Int{
        return dao.countGym()
    }

    fun totalVolume():Int {
        return dao.totalVolume()
    }

    fun progressTrainy(name: String):List<ExerciseRecord>{
        return dao.progressTrainy(name)
    }
}