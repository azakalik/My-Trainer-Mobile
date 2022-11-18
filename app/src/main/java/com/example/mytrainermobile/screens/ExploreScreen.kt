package com.example.mytrainermobile.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytrainermobile.util.getViewModelFactory
import com.example.mytrainermobile.viewModels.ExploreViewModel
import com.example.mytrainermobile.viewModels.ToggleFavouriteViewModelnterface

@Composable

fun ExploreScreen(
    onNavigateToStartWorkout: (id:Int) -> Unit,
) {
    val viewModel: ExploreViewModel = viewModel(factory = getViewModelFactory())
    var firstEntry by  remember  { mutableStateOf(true) }
    if ( firstEntry) {
        viewModel.loadRoutines()
        firstEntry = false
    }
    if(viewModel.uiState .message == null) {
        DefaultShowRoutinesScreen(
            title = "Explore Routines",
            onNavigateToStartWorkout,
            viewModel = viewModel,
        )
    }else{
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = viewModel.uiState.message!!,
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}

