package com.example.mytrainermobile.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytrainermobile.data.model.Cycle
import com.example.mytrainermobile.data.model.Review
import com.example.mytrainermobile.data.network.repository.FavouriteRepository
import com.example.mytrainermobile.data.network.repository.RoutineCyclesRepository
import com.example.mytrainermobile.data.network.repository.RoutineRepository
import com.example.mytrainermobile.screenStates.StartWorkoutState
import kotlinx.coroutines.launch

class StartWorkoutViewModel(
    private val routinesCyclesRepository: RoutineCyclesRepository,
    private val routinesRepository: RoutineRepository,
    private val favouritesRepository: FavouriteRepository
) : ViewModel() {

    var uiState by mutableStateOf(StartWorkoutState())
        private set

    //TODO INTENAR SOLUCIONAR ERROR DE REPOSITORY NO SIENDO UN SINGLETON
    suspend fun checkFavourite(id:Int) : Boolean {
        return favouritesRepository.isFavourited(id)
    }

    fun getRoutine(routineId: Int) = viewModelScope.launch {
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        kotlin.runCatching {
            routinesRepository.getRoutine(routineId)
        }.onSuccess { response ->
            if ( checkFavourite(response.id) )
                response.isFavourite = true
            uiState = uiState.copy(
                isFetching = false,
                routine = response
            )
        }.onFailure {  e ->
            uiState = uiState.copy(
                message = e.message,
                isFetching = false
            )
        }
    }

    fun makeFavourite(routineId: Int) = viewModelScope.launch {
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        uiState = uiState.copy( isFetching = true, message = null)
        runCatching {
            favouritesRepository.removeFavourite(routineId)
        }.onSuccess {
            val routine = uiState.routine?.copy(isFavourite = true)
            uiState = uiState.copy(routine = routine)
        }.onFailure {  e ->
            uiState = uiState.copy(
                message = e.message,
                isFetching = false
            )
        }
    }


    fun removeFavourite(routineId: Int) = viewModelScope.launch {
        uiState = uiState.copy( isFetching = true, message = null)
        runCatching {
            favouritesRepository.removeFavourite(routineId)
        }.onSuccess {
            val routine = uiState.routine?.copy(isFavourite = false)
            uiState = uiState.copy(routine = routine)
        }.onFailure {  e ->
            uiState = uiState.copy(
                message = e.message,
                isFetching = false
            )
        }

    }

    fun reviewRoutine(review: Review, id : Int) = viewModelScope.launch{
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        runCatching {
            routinesRepository.reviewRoutine(review, id)
        }.onSuccess { response ->
            uiState = uiState.copy(
                isFetching = false,
            )
        }.onFailure { e ->
            // Handle the error and notify the UI when appropriate.
            uiState = uiState.copy(
                message = e.message,
                isFetching = false)
        }
    }

    fun getRoutineCycles(routineId: Int) = viewModelScope.launch {
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        runCatching {
            routinesCyclesRepository.getRoutineCycles(routineId = routineId, refresh = true)
        }.onSuccess { response ->
            uiState = uiState.copy(
                isFetching = false,
                cycles = response
            )
        }.onFailure {  e ->
            uiState = uiState.copy(
                message = e.message,
                isFetching = false
            )
        }
    }

    fun openPopup(cycle: Cycle){
        uiState = uiState.copy(
            currentCycleForPopup = cycle,
        )
    }

    fun closePopup(){
        uiState = uiState.copy(
            currentCycleForPopup = null
        )
    }

}