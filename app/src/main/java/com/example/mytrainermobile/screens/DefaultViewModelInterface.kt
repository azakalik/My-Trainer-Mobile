package com.example.mytrainermobile.screens

import com.example.mytrainermobile.classes.Routine

interface DefaultViewModelInterface {
    fun getRoutines() : List<Routine>
}