package com.example.mytrainermobile.screens

import com.example.mytrainermobile.data.model.Routine

interface DefaultViewModelInterface {
    fun getRoutines() : List<Routine>

    suspend fun loadRoutines()
//
//    suspend fun makeFavourite(idx:Int)
//
//    suspend fun removeFavourite(idx:Int)
//
//    suspend fun accessRoutine(idx:Int) : Int
}