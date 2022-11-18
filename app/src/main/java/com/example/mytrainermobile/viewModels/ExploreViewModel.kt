package com.example.mytrainermobile.viewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytrainermobile.data.model.Review
import com.example.mytrainermobile.data.model.Routine
import com.example.mytrainermobile.data.network.repository.RoutineRepository
import com.example.mytrainermobile.screenStates.RoutineUIState
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ExploreViewModel(val routineRepository: RoutineRepository) : ViewModel(),
    DefaultViewModelInterface {
    var uiState by mutableStateOf(RoutineUIState())
        private set

    override fun loadRoutines(refresh: Boolean) = viewModelScope.launch {
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        kotlin.runCatching {
            //el repository sabe si debe refreshear o no
            routineRepository.getRoutines()
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

    override fun getState(): RoutineUIState {
        return uiState
    }

    override fun toggleShowSortFAB() {
        uiState = uiState.copy(
            showSortFAB = !(uiState.showSortFAB)
        )
    }

    override fun toggleAuxSortDescending() {
        uiState = uiState.copy(
            auxSortDescending = !(uiState.auxSortDescending),
            sortDirection = uiState.directionOptions[(uiState.index)%2],
            index = (uiState.index+1)
        )
    }

    override fun toggleAuxSortingBy(sortingOption: String) {
        uiState = uiState.copy(
            auxSortingBy = sortingOption
        )
    }

    override fun saveChanges(): Job = viewModelScope.launch {
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        kotlin.runCatching {
            //el repository sabe si debe refreshear o no
            routineRepository.getRoutinesSorted(uiState.auxSortingBy,uiState.sortDirection)
        }.onSuccess { suppliedRoutineList ->
            uiState = uiState.copy(isFetching = false, routineList = suppliedRoutineList)
        }.onFailure { except ->
            uiState = uiState.copy(
                message = except.message,
                isFetching = false
            )
        }
    }

    override fun unSaveChanges() {
        uiState = uiState.copy(
            auxSortingBy = uiState.sortingBy,
            auxSortDescending = uiState.sortDescending,
            index = 0
        )
    }
}