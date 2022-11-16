package com.example.mytrainermobile.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.mytrainermobile.R
import com.example.mytrainermobile.viewModels.FavouritesViewModel
import com.example.mytrainermobile.viewModels.ToggleFavouriteViewModelnterface

@Composable
fun FavouritesView(
    onNavigateToStartWorkout: (id:Int) -> Unit,
    viewModel: FavouritesViewModel,
    favouriteMaker: ToggleFavouriteViewModelnterface
    ) {
    DefaultShowRoutinesScreen(
        title = stringResource(id = R.string.myfavourites),
        onNavigateToStartWorkout,
        viewModel = viewModel,
        favouriteMaker = favouriteMaker
    )
}
