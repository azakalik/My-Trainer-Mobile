package com.example.mytrainermobile.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytrainermobile.data.network.repository.RoutineCyclesRepository
import com.example.mytrainermobile.data.network.repository.WorkoutScreenGetter
import com.example.mytrainermobile.screenStates.StartWorkoutState
import kotlinx.coroutines.launch

class StartWorkoutViewModel(
    private val routinesCyclesRepository: RoutineCyclesRepository,
    private val getters:List<WorkoutScreenGetter>
) : ViewModel() {

    var uiState by mutableStateOf(StartWorkoutState())

    fun initializeState(routineId: Int){
        getRoutineData(routineId)
        getRoutineCycles(routineId)
    }

    fun getRoutineData(routineId: Int): Unit{
        for ( r in getters){
            //en algun repositorio esta cacheado el dato
            val foundRoutine = r.getRoutine(routineId)
            if ( foundRoutine != null){
                uiState = uiState.copy(routine = foundRoutine)
                return;
            }
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