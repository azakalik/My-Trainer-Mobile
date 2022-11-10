package com.example.mytrainermobile.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mytrainermobile.viewModelStates.HomeUIState
import kotlinx.coroutines.Job

class HomeViewModel(): ViewModel() {


    var homeUIState by mutableStateOf( HomeUIState() )
        private set


    private var fetchHomeRoutinesJob: Job? = null

    fun fetchHomeRoutines(){
        fetchHomeRoutinesJob?.cancel()

    }


}