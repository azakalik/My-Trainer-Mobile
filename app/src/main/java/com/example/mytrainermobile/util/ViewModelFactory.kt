package com.example.mytrainermobile.util

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.mytrainermobile.data.network.repository.RoutineRepository
import com.example.mytrainermobile.data.network.repository.SportRepository
import com.example.mytrainermobile.data.network.repository.UserRepository
import com.example.mytrainermobile.ui.main.MainViewModel

class ViewModelFactory constructor(
    private val sessionManager: SessionManager,
    private val userRepository: UserRepository,
    private val sportRepository: SportRepository,
    private val routineRepository: RoutineRepository,
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
                MainViewModel(sessionManager, userRepository, sportRepository, routineRepository)
            else ->
                throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    } as T
}