package com.example.mytrainermobile

import android.app.Application
import com.example.mytrainermobile.data.network.api.RetrofitClient
import com.example.mytrainermobile.data.network.*
import com.example.mytrainermobile.data.network.repository.*
import com.example.mytrainermobile.util.SessionManager

class MyApplication : Application() {

    private val userRemoteDataSource: UserRemoteDataSource
        get() = UserRemoteDataSource(sessionManager, RetrofitClient.getApiUserService(this))

    private val sportRemoteDataSource: SportRemoteDataSource
        get() = SportRemoteDataSource(RetrofitClient.getApiSportService(this))

    private val routineRemoteDataSource: RoutineRemoteDataSource
        get() = RoutineRemoteDataSource(RetrofitClient.getApiRoutineService(this))

    private val favouriteRemoteDataSource: FavouriteRemoteDataSource
        get() = FavouriteRemoteDataSource(RetrofitClient.getApiFavouriteService(this))

    private val myRoutinesRemoteDataSource: MyRoutineRemoteDataSource
        get() = MyRoutineRemoteDataSource(RetrofitClient.getApiUserService(this))

    private val routineCyclesRemoteDataSource: RoutineCyclesRemoteDataSource
        get() = RoutineCyclesRemoteDataSource(RetrofitClient.getApiRoutineCyclesService(this))

    val sessionManager: SessionManager
        get() = SessionManager(this)

    val userRepository: UserRepository
        get() = UserRepository(userRemoteDataSource)

    val sportRepository: SportRepository
        get() = SportRepository(sportRemoteDataSource)

    val routineRepository: RoutineRepository
        get() = RoutineRepository(routineRemoteDataSource)

    val favouriteRepository: FavouriteRepository
        get() = FavouriteRepository(favouriteRemoteDataSource)

    val myRoutinesRepository: MyRoutinesRepository
        get() = MyRoutinesRepository(myRoutinesRemoteDataSource)

    val routineCyclesRepository: RoutineCyclesRepository
        get() = RoutineCyclesRepository(routineCyclesRemoteDataSource)
}