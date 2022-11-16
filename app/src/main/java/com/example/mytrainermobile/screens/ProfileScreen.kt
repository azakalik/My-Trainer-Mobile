package com.example.mytrainermobile.screens

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytrainermobile.components.DefaultButton
import com.example.mytrainermobile.ui.main.MainViewModel
import com.example.mytrainermobile.util.getViewModelFactory

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ShowProfileScreen(
    viewModel: MainViewModel = viewModel(factory = getViewModelFactory())
) {
    var counter by  remember  { mutableStateOf(0) }
    counter++
    Log.d("mensajeProfile",counter.toString())
    val uiState = viewModel.uiState
    val activity = (LocalContext.current as? Activity)
    viewModel.getCurrentUser()
    Column() {
        Text("Profile Screen")
        if(uiState.isAuthenticated){
            DefaultButton(onClick = { viewModel.logout(); activity?.finish() }, text = "Logout")

            val currentUserData = uiState.currentUser?.let {
                "Current User: ${it.firstName} ${it.lastName} (${it.email})"
            }
            Text(
                text = currentUserData?: "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                fontSize = 18.sp
            )
        }
        else
            Text("The user is not logged in yet")
    }

}