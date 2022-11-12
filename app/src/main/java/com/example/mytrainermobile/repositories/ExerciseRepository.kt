package com.example.mytrainermobile.repositories

import com.example.mytrainermobile.classes.Exercise

class ExerciseRepository {
    fun getExerciseById(id: Int): Exercise {
        return Exercise(
            id = 1,
            name = "exerciseName",
            detail = "exerciseDetail",
            category = "exerciseCategory",
            metadata = "exerciseMetadata",
        )
    }
}