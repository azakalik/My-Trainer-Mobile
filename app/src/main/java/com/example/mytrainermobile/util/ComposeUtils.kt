package com.example.mytrainermobile.util

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import com.example.mytrainermobile.MyApplication
import com.example.mytrainermobile.viewModels.FavouriteViewModel


@Composable
fun getViewModelFactory(defaultArgs: Bundle? = null): ViewModelFactory {
    val application = (LocalContext.current.applicationContext as MyApplication)
    val sessionManager = application.sessionManager
    val userRepository = application.userRepository
    val sportRepository = application.sportRepository
    return ViewModelFactory(
        sessionManager,
        userRepository,
        sportRepository,
        LocalSavedStateRegistryOwner.current,
        defaultArgs
    )
}

@Composable
fun getExploreViewModelFactory(defaultArgs: Bundle? = null): ExploreViewModelFactory {
    val application = (LocalContext.current.applicationContext as MyApplication)
    val sessionManager = application.sessionManager

    val routineRepository = application.routineRepository
    return ExploreViewModelFactory(
        sessionManager,
        routineRepository,
        LocalSavedStateRegistryOwner.current,
        defaultArgs
    )
}

@Composable
fun getFavouriteViewModelFactory(defaultArgs: Bundle? = null): FavouriteViewModelFactory {
    val application = (LocalContext.current.applicationContext as MyApplication)
    val sessionManager = application.sessionManager

    val favouriteRepository = application.favouriteRepository
    return FavouriteViewModelFactory(
        sessionManager,
        favouriteRepository,
        LocalSavedStateRegistryOwner.current,
        defaultArgs
    )
}