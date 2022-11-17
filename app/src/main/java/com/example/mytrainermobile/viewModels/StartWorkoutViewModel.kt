package com.example.mytrainermobile.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytrainermobile.data.model.Cycle
import com.example.mytrainermobile.data.network.repository.*
import com.example.mytrainermobile.screenStates.StartWorkoutState
import kotlinx.coroutines.launch

class StartWorkoutViewModel(
    private val routinesCyclesRepository: RoutineCyclesRepository,
    private val routinesRepository: RoutineRepository,
    private val favouritesRepository: FavouriteRepository,
    private val userRepository: UserRepository,
    private val reviewRepository: ReviewRepository
) : ViewModel() {

    var uiState by mutableStateOf(StartWorkoutState())
        private set

    //TODO INTENAR SOLUCIONAR ERROR DE REPOSITORY NO SIENDO UN SINGLETON
    suspend fun checkFavourite(id:Int) : Boolean {
        return favouritesRepository.isFavourited(id)
    }

    suspend fun getRoutineStats(){
        val userName = userRepository.getCurrentUser(refresh = true)?.username
        val userRating = reviewRepository.getUserRating(userName!!,uiState.routine!!.id)
        val routineRating = reviewRepository.getRoutineRating(uiState.routine!!.id)
        uiState = uiState.copy(currentUser = userName, userRating = userRating, routineRating = routineRating )
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

        kotlin.runCatching { getRoutineStats() }.onFailure { e ->
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
        favouritesRepository.makeFavourite(routineId)
        val routine = uiState.routine?.copy(isFavourite = true)
        uiState = uiState.copy(routine = routine)

    }


    fun removeFavourite(routineId: Int) = viewModelScope.launch {
        uiState = uiState.copy( isFetching = true, message = null)
        favouritesRepository.removeFavourite(routineId)
        val routine = uiState.routine?.copy(isFavourite = false)
        uiState = uiState.copy(routine = routine)
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