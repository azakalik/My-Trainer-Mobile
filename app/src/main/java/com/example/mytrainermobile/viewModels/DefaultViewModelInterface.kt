package com.example.mytrainermobile.viewModels

import com.example.mytrainermobile.data.model.Routine
import kotlinx.coroutines.Job

interface DefaultViewModelInterface {
    fun loadRoutines(refresh:Boolean = false) : Job
    fun getRoutineList() : List<Routine>
}