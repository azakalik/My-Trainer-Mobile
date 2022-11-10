package com.example.mytrainermobile.viewModelStates


import com.example.mytrainermobile.classes.Excercise


//guardo a que ciclo le corresponde
data class ExcercisesUIState(
    val cycleId: Int? = null,
    val cycleName: String? = null,
    val ExerciseList: List<Excercise> = listOf()
){}
