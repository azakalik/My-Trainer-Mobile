package com.example.mytrainermobile.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.mytrainermobile.R

@Composable
fun FavouritesView(
    onNavigateToMyRoutines: () -> Unit,
    onNavigateToFavourites: () -> Unit,
    onNavigateToExplore: () -> Unit,
    onNavigateToProfile: () -> Unit
) {
    DefaultShowRoutinesScreen(
        title = stringResource(id = R.string.myfavourites),
        onNavigateToMyRoutines,
        onNavigateToFavourites,
        onNavigateToExplore,
        onNavigateToProfile
    )
}
