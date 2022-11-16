package com.example.mytrainermobile.data.model

import com.example.mytrainermobile.data.network.model.NetworkCycleExercise

class CycleExercise(
    var exercise: Exercise,
    var order: Int,
    var duration: Int? = null,
    var repetitions: Int? = null,
    var metadata: String? = null
) {
    fun asNetworkModel() : NetworkCycleExercise {
        return NetworkCycleExercise(
            exercise = exercise.asNetworkModel(),
            order = order,
            duration = duration,
            repetitions = repetitions,
            metadata = metadata
        )
    }
}