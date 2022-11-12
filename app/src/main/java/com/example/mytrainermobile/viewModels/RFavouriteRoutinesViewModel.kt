package com.example.mytrainermobile.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.mytrainermobile.screenStates.RDefaultRoutinesUIState
import kotlinx.coroutines.Job

class FavouriteRoutinesViewModel {
    var favouriteRoutinesUIState by mutableStateOf(RDefaultRoutinesUIState())
        private set

    private var fetchFavouriteRoutinesJob: Job? = null

    fun fetchFavouriteRoutines(){
        fetchFavouriteRoutinesJob?.cancel()

    }
}