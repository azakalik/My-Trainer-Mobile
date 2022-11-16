package com.example.mytrainermobile.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.mytrainermobile.R
import com.example.mytrainermobile.viewModels.MyRoutinesViewModel
import com.example.mytrainermobile.viewModels.ToggleFavouriteViewModelnterface

@Composable
fun MyRoutines(
    onNavigateToStartWorkout: (id:Int) -> Unit,
    viewModel: MyRoutinesViewModel,
    favouriteMaker: ToggleFavouriteViewModelnterface
) {
    DefaultShowRoutinesScreen(
        title = stringResource(id = R.string.myroutines),
        onNavigateToStartWorkout,
        viewModel = viewModel,
        favouriteMaker = favouriteMaker
    )
}