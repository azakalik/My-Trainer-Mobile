package com.example.mytrainermobile.screens

import androidx.compose.runtime.Composable
import com.example.mytrainermobile.repositories.RoutineRepository
import com.example.mytrainermobile.viewModels.ExploreViewModel

@Composable

fun ExploreScreen(
    onNavigateToStartWorkout: () -> Unit,
    viewModel: ExploreViewModel
) {
    DefaultShowRoutinesScreen(
        title = "Explore Routines",
        onNavigateToStartWorkout,
        viewModel = viewModel
    )
}

