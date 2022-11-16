package com.example.mytrainermobile.screens

import androidx.compose.runtime.Composable
import com.example.mytrainermobile.viewModels.ExploreViewModel
import com.example.mytrainermobile.viewModels.ToggleFavouriteViewModelnterface

@Composable

fun ExploreScreen(
    onNavigateToStartWorkout: (id:Int) -> Unit,
    viewModel: ExploreViewModel,
    favouriteMaker: ToggleFavouriteViewModelnterface
) {
    DefaultShowRoutinesScreen(
        title = "Explore Routines",
        onNavigateToStartWorkout,
        viewModel = viewModel,
        favouriteMaker = favouriteMaker
    )
}

