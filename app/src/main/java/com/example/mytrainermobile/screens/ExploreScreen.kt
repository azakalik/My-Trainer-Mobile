package com.example.mytrainermobile.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable

fun ExploreScreen(

    onNavigateToStartWorkout: () -> Unit,
) {
    DefaultShowRoutinesScreen(

        title = "Explore Routines",
        onNavigateToStartWorkout
    )
}

