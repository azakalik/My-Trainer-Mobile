package com.example.mytrainermobile.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytrainermobile.R
import com.example.mytrainermobile.util.getViewModelFactory
import com.example.mytrainermobile.viewModels.FavouritesViewModel
import com.example.mytrainermobile.viewModels.ToggleFavouriteViewModelnterface

@Composable
fun FavouritesView(
    onNavigateToStartWorkout: (id:Int) -> Unit,
    //favouriteMaker: ToggleFavouriteViewModelnterface
    ) {

    val viewModel: FavouritesViewModel = viewModel(factory = getViewModelFactory())
    DefaultShowRoutinesScreen(
        title = stringResource(id = R.string.myfavourites),
        onNavigateToStartWorkout,
        viewModel = viewModel,
    //    favouriteMaker = favouriteMaker
    )
}
