package com.example.mytrainermobile.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytrainermobile.data.network.repository.FavouriteRepository
import com.example.mytrainermobile.screenStates.FavouriteState
import com.example.mytrainermobile.util.SessionManager
import kotlinx.coroutines.launch

class FavouriteViewModel(
    private val sessionManager: SessionManager,
    private val favouriteRepository: FavouriteRepository,
) : ViewModel() {

    var uiState by mutableStateOf(FavouriteState(isAuthenticated = sessionManager.loadAuthToken() != null))
        private set

    init {
        getFavourites()
    }


    fun getFavourites() = viewModelScope.launch {
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        runCatching {
            favouriteRepository.getFavourites()
        }.onSuccess { response ->
            uiState = uiState.copy(
                isFetching = false,
                favouriteRoutines = response
            )
        }.onFailure { e ->
            uiState = uiState.copy(
                message = e.message,
                isFetching = false
            )
        }
    }

    fun toggleFavourite(routineId: Int) = viewModelScope.launch {
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        runCatching {
            favouriteRepository.toggleFavourite(routineId)
        }.onSuccess { response ->
            uiState = uiState.copy(
                isFetching = false,
            )
            getFavourites()
        }.onFailure { e ->
            uiState = uiState.copy(
                message = e.message,
                isFetching = false
            )
        }

    }

    fun removeFavourite(routineId: Int) = viewModelScope.launch {
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        runCatching {
            favouriteRepository.removeFavourite(routineId)
        }.onSuccess { response ->
            uiState = uiState.copy(
                isFetching = false,
            )
            getFavourites()
        }.onFailure { e ->
            uiState = uiState.copy(
                message = e.message,
                isFetching = false
            )
        }
    }
}