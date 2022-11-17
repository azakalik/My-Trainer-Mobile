package com.example.mytrainermobile.util

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.mytrainermobile.data.network.repository.*
import com.example.mytrainermobile.ui.main.MainViewModel
import com.example.mytrainermobile.viewModels.*

class ViewModelFactory constructor(
    private val sessionManager: SessionManager,
    private val userRepository: UserRepository,
    private val sportRepository: SportRepository,
    private val routineRepository: RoutineRepository,
    private val myRoutinesRepository: MyRoutinesRepository,
    private val favouriteRepository: FavouriteRepository,
    private val routineCyclesRepository: RoutineCyclesRepository,
    private val cycleExercisesRepository: CycleExercisesRepository,
    private val reviewRepository: ReviewRepository,
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
                StartWorkoutViewModel(routineCyclesRepository, routineRepository,favouriteRepository,userRepository,reviewRepository)
            isAssignableFrom(RunningWorkout1ViewModel::class.java) ->
                RunningWorkout1ViewModel(cycleExercisesRepository, routineCyclesRepository)
            isAssignableFrom(MainViewModel::class.java) ->
                MainViewModel(sessionManager, userRepository, sportRepository, routineRepository)
            else ->
                throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    } as T
}