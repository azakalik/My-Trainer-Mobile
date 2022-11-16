package com.example.mytrainermobile.util

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.mytrainermobile.data.network.repository.*
import com.example.mytrainermobile.screenStates.StartWorkoutState
import com.example.mytrainermobile.ui.main.MainViewModel
import com.example.mytrainermobile.viewModels.ExploreViewModel
import com.example.mytrainermobile.viewModels.FavouritesViewModel
import com.example.mytrainermobile.viewModels.MyRoutinesViewModel
import com.example.mytrainermobile.viewModels.StartWorkoutViewModel

class ViewModelFactory constructor(
    private val sessionManager: SessionManager,
    private val userRepository: UserRepository,
    private val sportRepository: SportRepository,
    private val routineRepository: RoutineRepository,
    private val myRoutinesRepository: MyRoutinesRepository,
    private val favouriteRepository: FavouriteRepository,
    private val routineCyclesRepository: RoutineCyclesRepository,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ) = with(modelClass) {
        when {
            isAssignableFrom(ExploreViewModel::class.java) ->
                ExploreViewModel(routineRepository)
            isAssignableFrom(MyRoutinesViewModel::class.java) ->
                MyRoutinesViewModel(myRoutinesRepository)
            isAssignableFrom(FavouritesViewModel::class.java) ->
                FavouritesViewModel(favouriteRepository)
            isAssignableFrom(StartWorkoutViewModel::class.java) ->
                StartWorkoutViewModel(routineCyclesRepository,listOf(routineRepository,myRoutinesRepository,favouriteRepository))
            isAssignableFrom(MainViewModel::class.java) ->
                MainViewModel(sessionManager, userRepository, sportRepository, routineRepository)
            else ->
                throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    } as T
}