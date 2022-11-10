package com.example.mytrainermobile.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.mytrainermobile.R

@Composable
fun FavouritesView(
    navController: NavController,
    onNavigateToMyRoutines: () -> Unit,
    onNavigateToFavourites: () -> Unit,
    onNavigateToExplore: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onNavigateToStartWorkout: () -> Unit,
    ) {
    DefaultShowRoutinesScreen(
        navController,
        title = stringResource(id = R.string.myfavourites),
        onNavigateToMyRoutines,
        onNavigateToFavourites,
        onNavigateToExplore,
        onNavigateToProfile,
        onNavigateToStartWorkout,
    )
}
