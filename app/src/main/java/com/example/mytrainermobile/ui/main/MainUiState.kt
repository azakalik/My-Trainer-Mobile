package com.example.mytrainermobile.ui.main

import ar.edu.itba.example.api.data.model.Sport
import ar.edu.itba.example.api.data.model.User
import com.example.mytrainermobile.data.model.Routine


data class MainUiState(
    val isAuthenticated: Boolean = false,
    val isFetching: Boolean = false,
    val currentUser: User? = null,
    val sports: List<Sport>? = null,
    val currentSport: Sport? = null,
    val message: String? = null,
    val routines: List<Routine>? = null,
    val searchRoutines: List<Routine>? = null,
    val currentRoutine: Routine? = null,
)

val MainUiState.canGetCurrentUser: Boolean get() = isAuthenticated
val MainUiState.canGetAllSports: Boolean get() = isAuthenticated
val MainUiState.canGetCurrentSport: Boolean get() = isAuthenticated && currentSport != null
val MainUiState.canAddSport: Boolean get() = isAuthenticated && currentSport == null
val MainUiState.canModifySport: Boolean get() = isAuthenticated && currentSport != null
val MainUiState.canDeleteSport: Boolean get() = canModifySport
val MainUiState.errorOcurred: Boolean get() = message != null
