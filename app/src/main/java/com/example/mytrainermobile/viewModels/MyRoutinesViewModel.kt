package com.example.mytrainermobile.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytrainermobile.data.model.Routine
import com.example.mytrainermobile.data.network.repository.MyRoutinesRepository
import com.example.mytrainermobile.screenStates.RoutineUIState
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MyRoutinesViewModel(val routinesRepository: MyRoutinesRepository) : ViewModel(),
    DefaultViewModelInterface {
    var uiState by mutableStateOf(RoutineUIState())
    override fun loadRoutines(refresh:Boolean): Job = viewModelScope.launch {
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        kotlin.runCatching {
            //el repository sabe si debe refreshear o no
            routinesRepository.getRoutines(refresh)
        }.onSuccess { suppliedRoutineList ->
            uiState = uiState.copy(isFetching = false, routineList = suppliedRoutineList)
        }.onFailure { except ->
            uiState = uiState.copy(
                message = except.message,
                isFetching = false
            )
        }
    }

    override fun getRoutineList(): List<Routine> {
        return uiState.routineList
    }
}