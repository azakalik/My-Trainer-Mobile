package com.example.mytrainermobile.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mytrainermobile.screenStates.SortFABState

class SortFABViewModel : ViewModel() {
    var state by mutableStateOf(SortFABState())
        private set

    fun toggleShowSortFAB() {
        state = state.copy(
            showSortFAB = !(state.showSortFAB)
        )
    }

    fun toggleAuxSortDescending(){
        state = state.copy(
            auxSortDescending = !(state.auxSortDescending)
        )
    }

    fun toggleAuxSortingBy(sortingOption: String) {
        state = state.copy(
            auxSortingBy = sortingOption
        )
    }

    fun saveChanges() {
        state = state.copy(
            sortingBy = state.auxSortingBy,
            sortDescending = state.auxSortDescending,
        )
    }

    fun unSaveChanges() {
        state = state.copy(
            auxSortingBy = state.sortingBy,
            auxSortDescending = state.sortDescending,
        )
    }
}