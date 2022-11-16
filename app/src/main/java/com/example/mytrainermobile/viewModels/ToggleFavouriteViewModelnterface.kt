package com.example.mytrainermobile.viewModels

import com.example.mytrainermobile.data.model.Routine
import kotlinx.coroutines.Job

interface ToggleFavouriteViewModelnterface {
    fun makeFavourite(routineId: Int) : Job
    fun removeFavourite(routineId: Int) : Job
    fun loadRoutines() : Job
    fun getRoutineList() : List<Routine>
}