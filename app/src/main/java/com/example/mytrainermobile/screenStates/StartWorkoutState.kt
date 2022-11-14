package com.example.mytrainermobile.screenStates

import com.example.mytrainermobile.data.classes.Cycle
import com.example.mytrainermobile.data.classes.Routine

data class StartWorkoutState(
    val cycles: List<Cycle> = listOf(),
    val isLoading: Boolean = false,
    val routine: Routine
)
