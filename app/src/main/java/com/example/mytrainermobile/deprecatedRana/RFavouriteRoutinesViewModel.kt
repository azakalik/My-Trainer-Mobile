package com.example.mytrainermobile.deprecatedRana
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.Job

class RFavouriteRoutinesViewModel {
    var favouriteRoutinesUIState by mutableStateOf(RDefaultRoutinesUIState())
        private set

    private var fetchFavouriteRoutinesJob: Job? = null

    fun fetchFavouriteRoutines(){
        fetchFavouriteRoutinesJob?.cancel()

    }
}