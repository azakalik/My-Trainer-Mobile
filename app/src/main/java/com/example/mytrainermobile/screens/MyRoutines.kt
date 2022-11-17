package com.example.mytrainermobile.screens

import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytrainermobile.R
import com.example.mytrainermobile.util.getViewModelFactory
import com.example.mytrainermobile.viewModels.MyRoutinesViewModel
import com.example.mytrainermobile.viewModels.ToggleFavouriteViewModelnterface

@Composable
fun MyRoutines(
    onNavigateToStartWorkout: (id:Int) -> Unit,
) {

    val viewModel : MyRoutinesViewModel = viewModel(factory = getViewModelFactory())
    var firstEntry by  remember  { mutableStateOf(true) }
    if ( firstEntry) {
        viewModel.loadRoutines()
        firstEntry = false
    }
    DefaultShowRoutinesScreen(
        title = stringResource(id = R.string.myroutines),
        onNavigateToStartWorkout,
        viewModel = viewModel
    )
}