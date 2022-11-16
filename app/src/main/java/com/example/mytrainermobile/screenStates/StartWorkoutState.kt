package com.example.mytrainermobile.screenStates

import com.example.mytrainermobile.data.model.Cycle
import com.example.mytrainermobile.data.model.Routine

data class StartWorkoutState(
    val routine: Routine? = null,
    val cycles: List<Cycle> = listOf(),
    val isFetching: Boolean = false,
    val message: String? = null,
)
