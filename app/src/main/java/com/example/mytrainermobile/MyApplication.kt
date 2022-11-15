package com.example.mytrainermobile

import android.app.Application
import com.example.mytrainermobile.data.network.SportRemoteDataSource
import com.example.mytrainermobile.data.network.UserRemoteDataSource
import ar.edu.itba.example.api.data.network.api.RetrofitClient
import com.example.mytrainermobile.data.network.FavouriteRemoteDataSource
import com.example.mytrainermobile.data.network.RoutineRemoteDataSource
import com.example.mytrainermobile.data.network.repository.FavouriteRepository
import com.example.mytrainermobile.data.network.repository.RoutineRepository
import com.example.mytrainermobile.data.network.repository.SportRepository
import com.example.mytrainermobile.data.network.repository.UserRepository
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
}