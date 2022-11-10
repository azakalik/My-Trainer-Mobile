package com.example.mytrainermobile.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable

fun ExploreScreen(onNavigateToMyRoutines: () -> Unit,
                  onNavigateToFavourites: () -> Unit,
                  onNavigateToExplore: () -> Unit,
                  onNavigateToProfile: () -> Unit,
                  onNavigateToStartWorkout: () -> Unit,) {
    DefaultShowRoutinesScreen(title = "Explore Routines", onNavigateToMyRoutines, onNavigateToFavourites, onNavigateToExplore, onNavigateToProfile, onNavigateToStartWorkout)
}

