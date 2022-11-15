package com.example.mytrainermobile.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mytrainermobile.deprecatedRana.RDefaultRoutinesUIState
import kotlinx.coroutines.Job

class IndividualExerciseViewModel : ViewModel() {

    var myIndivudalExerciseUIState by mutableStateOf(RDefaultRoutinesUIState())
        private set

    private var fetchMyRoutinesJob: Job? = null

    fun fetchMyIndividualExercise(exerciseId: Int){
        fetchMyRoutinesJob?.cancel()

    }
}