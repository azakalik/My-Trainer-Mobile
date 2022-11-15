package com.example.mytrainermobile.screens

import com.example.mytrainermobile.data.model.Routine
import kotlinx.coroutines.Job

interface DefaultViewModelInterface {
    fun loadRoutines() : Job
    fun getRoutineList() : List<Routine>
}