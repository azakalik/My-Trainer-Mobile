package com.example.mytrainermobile.screenStates

import com.example.mytrainermobile.data.model.Exercise

class RunningWorkout1State (
    val exercises: List<Exercise> = listOf(),
    var currentExerciseIndex : Int = 0,
    var currentTime : Long = exercises[currentExerciseIndex].duration * 1000L,
    var isRunning : Boolean = false,
    var isPaused : Boolean = false,
    val reps : Int = exercises[currentExerciseIndex].repetitions,

    )