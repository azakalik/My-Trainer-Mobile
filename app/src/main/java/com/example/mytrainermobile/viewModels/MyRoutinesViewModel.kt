package com.example.mytrainermobile.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.mytrainermobile.viewModelStates.DefaultRoutinesUIState
import kotlinx.coroutines.Job

class MyRoutinesViewModel {

    var myRoutinesUIState by mutableStateOf(DefaultRoutinesUIState())
        private set

    private var fetchMyRoutinesJob: Job? = null

    fun fetchMyRoutines(){
        fetchMyRoutinesJob?.cancel()

    }
}