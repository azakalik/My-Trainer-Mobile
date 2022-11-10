package com.example.mytrainermobile.viewModelStates

import com.example.mytrainermobile.classes.Routine

//TODO podemos hacer que el usuario vea su nombre, displayar un mensaje tipo
// Glad to have you back....
class ExploreUIState(val userRealName: String? = null, val routineList: List<Routine> = listOf() ) {
}