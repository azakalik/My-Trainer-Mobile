package com.example.mytrainermobile.screenStates

import com.example.mytrainermobile.data.model.Routine

data class RoutineUIState (
    val message:String? = null,
    val isFetching: Boolean = false,
    val routineList: List<Routine> = emptyList()
    )