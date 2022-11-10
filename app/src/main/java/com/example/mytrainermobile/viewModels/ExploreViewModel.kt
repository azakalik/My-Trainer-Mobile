package com.example.mytrainermobile.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mytrainermobile.viewModelStates.ExploreUIState
import kotlinx.coroutines.Job

class ExploreViewModel(): ViewModel() {


    var homeUIState by mutableStateOf( ExploreUIState() )
        private set


    private var fetchHomeRoutinesJob: Job? = null

    fun fetchHomeRoutines(){
        fetchHomeRoutinesJob?.cancel()

    }


}