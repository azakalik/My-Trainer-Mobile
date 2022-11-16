package com.example.mytrainermobile.viewModels

import kotlinx.coroutines.Job

interface ToggleFavouriteViewModelnterface {
    fun makeFavourite(routineId: Int) : Job
    fun removeFavourite(routineId: Int) : Job
}