package com.example.mytrainermobile.screenStates

import com.example.mytrainermobile.data.classes.Routine

//TODO podemos hacer que el usuario vea su nombre, displayar un mensaje tipo
// Glad to have you back....
class RDefaultRoutinesUIState(val userRealName: String? = null, val routineList: List<Routine> = listOf() ) {
}