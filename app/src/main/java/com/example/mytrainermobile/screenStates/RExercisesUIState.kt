package com.example.mytrainermobile.screenStates


import com.example.mytrainermobile.data.model.Cycle
import com.example.mytrainermobile.data.model.Exercise


//guardo a que ciclo le corresponde
data class ExcercisesUIState(
    val routineId: Int? = null,
    //CON ROUTINEid RECUPERO LOS idx de losCYCLOS
    val currentCycleIdx: Int = 0,
    val Cycles: List<Cycle> = listOf(),
    //uso CyclesData.id
    val exerciseMap: Map<Int,List<Exercise>> = mapOf(),
)
