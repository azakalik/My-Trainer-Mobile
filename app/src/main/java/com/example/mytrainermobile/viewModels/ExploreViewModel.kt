package com.example.mytrainermobile.viewModels

import androidx.lifecycle.ViewModel
import com.example.mytrainermobile.data.model.Routine
import com.example.mytrainermobile.data.network.repository.RoutineRepository
import com.example.mytrainermobile.screens.DefaultViewModelInterface

class ExploreViewModel : ViewModel(), DefaultViewModelInterface{
    private var routineList = null

    override fun getRoutines() : List<Routine>{
        return listOf()
    }
}