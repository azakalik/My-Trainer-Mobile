package com.example.mytrainermobile.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytrainermobile.data.network.repository.CycleRepository
import com.example.mytrainermobile.data.network.repository.RoutineRepository
import com.example.mytrainermobile.screenStates.StartWorkoutState
import kotlinx.coroutines.launch

class StartWorkoutViewModel(routineId: Int) : ViewModel() {

    var state by mutableStateOf(StartWorkoutState(routine = RoutineRepository().getRoutineById(routineId)))
        private set

    init {
        var it = iterator<Int> { state.routine.cycleIds }
        viewModelScope.launch {
            state = state.copy(
                isLoading = true
            )
            state = state.copy(
                cycles = CycleRepository().getCycles() ,
                //cycles = CycleRepository().getCycles(),
                isLoading = false
            )
        }
    }

    fun rateRoutine() {

    }

}