package com.example.mytrainermobile.screenStates

import com.example.mytrainermobile.data.model.Cycle
import com.example.mytrainermobile.data.model.CycleExercise
import com.example.mytrainermobile.data.model.Exercise

data class RunningWorkout1State (
    val cycleExercises: List<CycleExercise> = listOf(),
    val cycles: List<Cycle>? = listOf(),
    val isFetching: Boolean = false,
    val message: String? = null,
    val currentCycle: Cycle? = null,
    val running: Boolean = false,
)
val RunningWorkout1State.hasExercises: Boolean get() = cycleExercises.isNotEmpty()

