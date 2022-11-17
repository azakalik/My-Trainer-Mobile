package com.example.mytrainermobile.viewModels

import com.example.mytrainermobile.data.model.Routine
import com.example.mytrainermobile.screenStates.RoutineUIState
import kotlinx.coroutines.Job

interface DefaultViewModelInterface {
    fun loadRoutines() : Job
    fun getRoutineList() : List<Routine>
    fun getState(): RoutineUIState
    fun toggleShowSortFAB()
    fun toggleAuxSortDescending()
    fun toggleAuxSortingBy(sortingOption: String)
    fun saveChanges(): Job
    fun unSaveChanges()
}