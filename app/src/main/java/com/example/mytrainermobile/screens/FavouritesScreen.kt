package com.example.mytrainermobile.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.mytrainermobile.R
import com.example.mytrainermobile.repositories.RoutineRepository
import com.example.mytrainermobile.viewModels.FavouritesViewModel

@Composable
fun FavouritesView(
    onNavigateToStartWorkout: () -> Unit,
    viewModel: FavouritesViewModel
    ) {
    DefaultShowRoutinesScreen(
        title = stringResource(id = R.string.myfavourites),
        onNavigateToStartWorkout,
        viewModel = viewModel
    )
}
