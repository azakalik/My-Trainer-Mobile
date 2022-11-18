package com.example.mytrainermobile.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytrainermobile.R
import com.example.mytrainermobile.util.getViewModelFactory
import com.example.mytrainermobile.viewModels.FavouritesViewModel
import com.example.mytrainermobile.viewModels.ToggleFavouriteViewModelnterface

@Composable
fun FavouritesView(
    onNavigateToStartWorkout: (id:Int) -> Unit,
    ) {

    val viewModel: FavouritesViewModel = viewModel(factory = getViewModelFactory())

    viewModel.loadRoutines(refresh = true)
    if(viewModel.uiState .message == null) {

        DefaultShowRoutinesScreen(
            title = stringResource(id = R.string.myfavourites),
            onNavigateToStartWorkout,
            viewModel = viewModel,
            false
        )
    }
    else{
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
