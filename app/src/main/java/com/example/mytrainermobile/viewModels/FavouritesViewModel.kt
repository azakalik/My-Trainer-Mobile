package com.example.mytrainermobile.viewModels

import androidx.lifecycle.ViewModel
import com.example.mytrainermobile.data.model.Routine
import com.example.mytrainermobile.data.network.repository.RoutineRepository
import com.example.mytrainermobile.screens.DefaultViewModelInterface

class FavouritesViewModel : ViewModel(), DefaultViewModelInterface {
    private var routineList = RoutineRepository().getFavouriteRoutines()

    override fun getRoutines() : List<Routine>{
        return routineList
    }
}