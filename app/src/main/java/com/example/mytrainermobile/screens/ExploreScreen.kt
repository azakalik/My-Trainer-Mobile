package com.example.mytrainermobile.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable

fun ExploreScreen(
    navController: NavController,
    onNavigateToMyRoutines: () -> Unit,
    onNavigateToFavourites: () -> Unit,
    onNavigateToExplore: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onNavigateToStartWorkout: () -> Unit,
) {
    DefaultShowRoutinesScreen(
        navController,

        title = "Explore Routines",
        onNavigateToMyRoutines,
        onNavigateToFavourites,
        onNavigateToExplore,
        onNavigateToProfile,
        onNavigateToStartWorkout
    )
}

