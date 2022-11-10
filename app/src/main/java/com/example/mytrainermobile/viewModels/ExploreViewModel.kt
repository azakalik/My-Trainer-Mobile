package com.example.mytrainermobile.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mytrainermobile.viewModelStates.DefaultRoutinesUIState
import kotlinx.coroutines.Job

class ExploreViewModel(): ViewModel() {


    var exploreUIState by mutableStateOf( DefaultRoutinesUIState() )
        private set


    private var fetchExploreRoutinesJob: Job? = null

    fun fetchExploreRoutines(){
        fetchExploreRoutinesJob?.cancel()

    }


}