package com.example.andegym.data.parser

import android.content.Context
import com.example.andegym.data.model.TrainingDay
import kotlinx.serialization.json.Json


fun TrainingPlanParser(context: Context):List<TrainingDay>{
    val jsonText=context.assets
        .open("training_plan.json")
        .bufferedReader()
        .use{it.readText()}
    val days= Json.decodeFromString<List<TrainingDay>>(jsonText)
    return days
}