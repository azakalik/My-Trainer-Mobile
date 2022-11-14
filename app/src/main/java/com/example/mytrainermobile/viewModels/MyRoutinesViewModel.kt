package com.example.mytrainermobile.viewModels

import androidx.lifecycle.ViewModel
import com.example.mytrainermobile.data.classes.Routine
import com.example.mytrainermobile.data.network.repository.RoutineRepository
import com.example.mytrainermobile.screens.DefaultViewModelInterface

class MyRoutinesViewModel() : ViewModel(), DefaultViewModelInterface {
    private var routineList = RoutineRepository().getUserRoutines()

    override fun getRoutines() : List<Routine>{
        return routineList
    }
}