package com.example.mytrainermobile.aux_functions

import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarResult
import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch




data class SnackBarDisplayData(val scaffoldState: ScaffoldState, val coroutine: CoroutineScope,val message: String)

//todo LA IDEA ES QUE EL ONCLICK LLAME A UNA FUTURA FUNCION FAVOURITErOUTINE Y ESA LLAME A ESTA SNACKBAR ON SUCCESS
fun displaySnackBar(scaffoldState: ScaffoldState, coroutine: CoroutineScope, message: String) {
    coroutine.launch {
        scaffoldState.snackbarHostState.showSnackbar(
            message = message,
            duration = SnackbarDuration.Short
        )
    }
}