package com.example.mytrainermobile.deprecatedRana

import androidx.compose.runtime.mutableStateOf
import com.example.mytrainermobile.screenStates.ExcercisesUIState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException


class RExerciseListViewModel() : ViewModel() {


    var exercisesUiState  = mutableStateOf(ExcercisesUIState())
        private set

    private var fetchExerciseListJob: Job? = null

    fun fetchExercises(cycleid:Int){

        fetchExerciseListJob?.cancel()


        fetchExerciseListJob = viewModelScope.launch {
            try {
                //val signingInUserUIState = repository.fetchExercises(cycleId = cycleId)
                //exercisesUiState = exercisesUiState
            } catch (ioe: IOException){
                //TODO no encuentra getMessageFromTrhowable
//                val msg = ioe.message
//                signingInUserUIState = signingInUserUIState.copy(errorMessage = msg)
            }
        }
    }
}