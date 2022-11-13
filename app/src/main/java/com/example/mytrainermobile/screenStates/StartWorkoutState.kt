package com.example.mytrainermobile.screenStates

import com.example.mytrainermobile.classes.Cycle
import com.example.mytrainermobile.classes.Routine

data class StartWorkoutState(
    val cycles: List<Cycle> = listOf(),
    val isLoading: Boolean = false,
    val routine: Routine
)
