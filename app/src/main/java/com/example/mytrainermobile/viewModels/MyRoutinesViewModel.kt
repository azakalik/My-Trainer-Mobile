package com.example.mytrainermobile.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mytrainermobile.data.model.Routine
import com.example.mytrainermobile.data.network.repository.RoutineRepository
import com.example.mytrainermobile.screenStates.RoutinesUIState
import com.example.mytrainermobile.screens.DefaultViewModelInterface
import com.example.mytrainermobile.util.SessionManager

class MyRoutinesViewModel(val routineRepository: RoutineRepository) : ViewModel(), DefaultViewModelInterface {

    var uiState by mutableStateOf( RoutinesUIState() )
        private set


    override fun getRoutines() : List<Routine>{
        return uiState.routineList
    }


    override suspend fun loadRoutines() {
        //por ahroa busca a la API solo una vez, estamos sin refresh
        uiState = uiState.copy(routineList = routineRepository.getRoutines() )
    }
//
//    override suspend fun makeFavourite(idx:Int) {
//        TODO("LLamar a favourite repository")
//    }
//
//    override suspend fun removeFavourite(idx:Int) {
//        TODO("llamar a favourite repository")
//    }
//
//    override suspend fun accessRoutine(idx:Int): Int {
//        return uiState[idx].id
//    }


}