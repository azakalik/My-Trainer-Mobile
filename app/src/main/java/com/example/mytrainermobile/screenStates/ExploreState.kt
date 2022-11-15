package com.example.mytrainermobile.screenStates

import ar.edu.itba.example.api.data.model.User
import com.example.mytrainermobile.data.model.Routine

data class ExploreState(
    val isAuthenticated: Boolean = false,
    val isFetching: Boolean = false,
    val message: String? = null,
    val routines: List<Routine>? = null,
    val searchRoutines: List<Routine>? = null,
    val currentRoutine: Routine? = null,
) {
}