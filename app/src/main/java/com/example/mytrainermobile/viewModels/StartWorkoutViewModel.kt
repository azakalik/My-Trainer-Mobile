package com.example.mytrainermobile.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytrainermobile.data.network.repository.RoutineCyclesRepository
import com.example.mytrainermobile.data.network.repository.RoutineRepository
import com.example.mytrainermobile.screenStates.StartWorkoutState
import kotlinx.coroutines.launch

class StartWorkoutViewModel(
    private val routinesCyclesRepository: RoutineCyclesRepository,
    private val routinesRepository: RoutineRepository,
) : ViewModel() {

    var uiState by mutableStateOf(StartWorkoutState())

    fun getRoutine(routineId: Int) = viewModelScope.launch {
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        kotlin.runCatching {
            routinesRepository.getRoutine(routineId)
        }.onSuccess { response ->
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

}