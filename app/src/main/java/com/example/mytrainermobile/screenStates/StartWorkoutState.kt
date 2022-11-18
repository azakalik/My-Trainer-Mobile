package com.example.mytrainermobile.screenStates

import com.example.mytrainermobile.data.model.Cycle
import com.example.mytrainermobile.data.model.Routine
import com.example.mytrainermobile.ui.main.MainUiState

data class StartWorkoutState(
    val routine: Routine? = null,
    val cycles: List<Cycle> = listOf(),
    val isFetching: Boolean = false,
    val message: String? = null,
    val currentUser: String? = null,
    val userRating:Int? = null,
    val routineRating:Double? = null,
    val currentCycleForPopup : Cycle? = null //null if no popup is shown
)

val StartWorkoutState.showPopup: Boolean get() = currentCycleForPopup != null
val StartWorkoutState.canExecute: Boolean get() = cycles.isNotEmpty()
