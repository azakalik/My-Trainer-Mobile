package com.example.mytrainermobile.util

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.mytrainermobile.data.network.repository.FavouriteRepository
import com.example.mytrainermobile.ui.main.MainViewModel
import com.example.mytrainermobile.viewModels.FavouriteViewModel

class FavouriteViewModelFactory constructor(
    private val sessionManager: SessionManager,
    private val favouriteRepository: FavouriteRepository,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ) = with(modelClass) {
        when {
            isAssignableFrom(MainViewModel::class.java) ->
                FavouriteViewModel(sessionManager, favouriteRepository)
            else ->
                throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    } as T
}