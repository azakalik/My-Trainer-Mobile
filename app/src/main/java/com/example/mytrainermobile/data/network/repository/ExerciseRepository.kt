package com.example.mytrainermobile.data.network.repository

import com.example.mytrainermobile.data.model.Exercise

class ExerciseRepository {
    fun getExerciseById(id: Int): Exercise {
        return Exercise(
            id = 1,
            name = "exerciseName",
            detail = "exerciseDetail",
            category = "exerciseCategory",
            metadata = "exerciseMetadata",
            duration = 30,
            repetitions = 0
        )
    }
}