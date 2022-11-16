package com.example.mytrainermobile.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytrainermobile.util.getViewModelFactory
import com.example.mytrainermobile.viewModels.ExploreViewModel
import com.example.mytrainermobile.viewModels.ToggleFavouriteViewModelnterface

@Composable

fun ExploreScreen(
    onNavigateToStartWorkout: (id:Int) -> Unit,
) {
    val viewModel: ExploreViewModel = viewModel(factory = getViewModelFactory())
    DefaultShowRoutinesScreen(
        title = "Explore Routines",
        onNavigateToStartWorkout,
        viewModel = viewModel,

    )
}

