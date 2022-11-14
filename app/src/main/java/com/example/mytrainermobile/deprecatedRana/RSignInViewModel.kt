package com.example.mytrainermobile.deprecatedRana

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytrainermobile.screenStates.RSigningInUserUIState
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

//TODO PASAR REPOSITORY CUANDO VEAMOS
class signInViewModel() : ViewModel() {

    var signingInUserUIState by mutableStateOf(RSigningInUserUIState())
        private set


    private var fetchUserLogin: Job? = null

    //cuando esta funcion se complete, cambio el estado desde aqui, dicho cambio de estado tiene que causar el avance,
    //osea en definitiva, la accion de tocar el boton SIGN IN --> llama a funcion fetch en viewModel --> comunica con repository
    //--> comunica con la api --> cambia estado de repository --> cambia estado de viewModel --> el estado de loggedIn cambia a true
    // --> eso triggerea el navigator para avanzar a home!

    fun fetchSignUserIn(){
        fetchUserLogin?.cancel()
        fetchUserLogin = viewModelScope.launch {
            try {
                //val signingInUserUIState = repository.signInUser()
                signingInUserUIState = signingInUserUIState.copy(isLoggedIn = true)
            } catch (ioe: IOException){
                //TODO no encuentra getMessageFromTrhowable
                val msg = ioe.message
                signingInUserUIState = signingInUserUIState.copy(errorMessage = msg)
            }
        }
    }
}