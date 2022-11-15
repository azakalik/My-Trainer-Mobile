package com.example.mytrainermobile.screenStates

import ar.edu.itba.example.api.data.model.User
import com.example.mytrainermobile.data.model.Routine

data class FavouriteState(
    val isAuthenticated: Boolean = false,
    val isFetching: Boolean = false,
    val message: String? = null,
    val currentUser: User? = null,
    val favouriteRoutines: List<Routine>? = null,
) {
}