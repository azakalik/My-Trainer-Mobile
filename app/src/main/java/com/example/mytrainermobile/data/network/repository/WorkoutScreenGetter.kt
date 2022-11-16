package com.example.mytrainermobile.data.network.repository

import com.example.mytrainermobile.data.model.Routine

interface WorkoutScreenGetter {

    fun getRoutine(id:Int) : Routine?
}