package com.example.mytrainermobile.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mytrainermobile.screenStates.RDefaultRoutinesUIState
import kotlinx.coroutines.Job

class RExploreViewModel(): ViewModel() {


    var exploreUIState by mutableStateOf( RDefaultRoutinesUIState() )
        private set


    private var fetchExploreRoutinesJob: Job? = null

    fun fetchExploreRoutines(){
        fetchExploreRoutinesJob?.cancel()

    }


}