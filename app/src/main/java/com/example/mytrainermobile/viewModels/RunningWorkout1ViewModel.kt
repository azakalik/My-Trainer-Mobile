package com.example.mytrainermobile.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytrainermobile.data.model.Cycle
import com.example.mytrainermobile.data.network.repository.CycleExercisesRepository
import com.example.mytrainermobile.data.network.repository.RoutineCyclesRepository
import com.example.mytrainermobile.screenStates.RunningWorkout1State
import kotlinx.coroutines.launch

class RunningWorkout1ViewModel(
    private val cycleExercisesRepository: CycleExercisesRepository,
    private val routinesCyclesRepository: RoutineCyclesRepository,
    ) : ViewModel() {

    var uiState by mutableStateOf(RunningWorkout1State())
        private set


    fun getCycleExercises(cycleId: Int) = viewModelScope.launch {
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        runCatching {
            cycleExercisesRepository.getCycleExercises(cycleId = cycleId, refresh = true)
        }.onSuccess { response ->
            uiState = uiState.copy(
                isFetching = false,
                cycleExercises = response,
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
    fun setCurrentCycle(cycle: Cycle){
        uiState = uiState.copy(
            currentCycle = cycle
        )
    }
}