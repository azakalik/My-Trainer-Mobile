package com.example.mytrainermobile.screens

import com.example.mytrainermobile.data.classes.Routine

interface DefaultViewModelInterface {
    fun getRoutines() : List<Routine>
}