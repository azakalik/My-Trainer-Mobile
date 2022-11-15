package com.example.mytrainermobile.screens

import com.example.mytrainermobile.data.model.Routine

interface DefaultViewModelInterface {
    fun getRoutines() : List<Routine>
}