package com.example.mytrainermobile.screenStates

import com.example.mytrainermobile.data.model.Cycle
import com.example.mytrainermobile.data.model.CycleExercise

data class IndividualExerciseScreenState(
    val cycles: List<Cycle> = listOf(),
    val cycle: Cycle? = null,
    val cycleIndex: Int = 0,
    val cycleReps: Int = 0,
    val cycleExercises: List<CycleExercise> = listOf(),
    val exercise: CycleExercise? = null,
    val exerciseIndex:Int = 0,
    //val exerciseTime:Long = 0L,

    val isPaused:Boolean = false,
    val finished:Boolean = false,

    val isFetching: Boolean = false,
    val message: String? = null,
) {
}