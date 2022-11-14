package com.example.mytrainermobile.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    val uiState = viewModel.uiState
    Column() {
        Text("Profile Screen")
        if(uiState.isAuthenticated){
            DefaultButton(onClick = { viewModel.logout() }, text = "Logout")

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
            Text("The user is not logged in yer")
    }

}