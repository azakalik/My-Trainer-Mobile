package com.example.mytrainermobile.viewModelStates


import com.example.mytrainermobile.classes.CyclesData
import com.example.mytrainermobile.classes.Excercise


//guardo a que ciclo le corresponde
data class ExcercisesUIState(
    val routineId: Int? = null,
    //CON ROUTINEid RECUPERO LOS idx de losCYCLOS
    val currentCycleIdx: Int = 0,
    val Cycles: List<CyclesData> = listOf(),
    //uso CyclesData.id
    val exerciseMap: Map<Int,List<Excercise>> = mapOf(),
)
