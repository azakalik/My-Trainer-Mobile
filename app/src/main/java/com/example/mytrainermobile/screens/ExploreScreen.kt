package com.example.mytrainermobile.screens

import androidx.compose.runtime.Composable
import com.example.mytrainermobile.repositories.RoutineRepository

@Composable

fun ExploreScreen(

    onNavigateToStartWorkout: () -> Unit,
) {
    DefaultShowRoutinesScreen(

        title = "Explore Routines",
        onNavigateToStartWorkout,
        routineList = RoutineRepository().getAllRoutines(),
    )
}

