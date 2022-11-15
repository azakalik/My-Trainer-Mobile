package com.example.mytrainermobile.deprecatedRana

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.Job

class RMyRoutinesViewModel {

    var myRoutinesUIState by mutableStateOf(RDefaultRoutinesUIState())
        private set

    private var fetchMyRoutinesJob: Job? = null

    fun fetchMyRoutines(){
        fetchMyRoutinesJob?.cancel()

    }
}