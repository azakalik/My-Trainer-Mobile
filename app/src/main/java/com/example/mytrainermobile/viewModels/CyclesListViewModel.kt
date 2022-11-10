package com.example.mytrainermobile.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mytrainermobile.viewModelStates.CyclesUIState
import kotlinx.coroutines.Job
import java.io.IOException

class CyclesListViewModel() : ViewModel() {


    var cyclesUIState by mutableStateOf(CyclesUIState())
        private set
    private var fetchCycles: Job? = null

    fun fetchCycles(routineId: Int){
        fetchCycles?.cancel()
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