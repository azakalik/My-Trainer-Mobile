package com.example.mytrainermobile.screenStates

import com.example.mytrainermobile.data.model.Cycle
import com.example.mytrainermobile.data.model.CycleExercise
import com.example.mytrainermobile.data.model.Exercise

data class RunningWorkout1State (
    val cycleExercises: List<CycleExercise>? = emptyList(),
    val cycles: List<Cycle>? = emptyList(),
    val isFetching: Boolean = false,
    val message: String? = null,

    /*
    var currentExerciseIndex : Int = 0,
    var currentTime : Long = exercises[currentExerciseIndex].duration * 1000L,
    var isRunning : Boolean = false,
    var isPaused : Boolean = false,
    val reps : Int = exercises[currentExerciseIndex].repetitions,
    */
)
