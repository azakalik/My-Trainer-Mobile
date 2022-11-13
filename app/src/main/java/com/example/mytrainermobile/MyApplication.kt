package com.example.mytrainermobile

import android.app.Application
import com.example.mytrainermobile.network.SportRemoteDataSource
import com.example.mytrainermobile.network.UserRemoteDataSource
import ar.edu.itba.example.api.data.network.api.RetrofitClient
import com.example.mytrainermobile.repository.SportRepository
import com.example.mytrainermobile.repository.UserRepository
import com.example.mytrainermobile.util.SessionManager

class MyApplication : Application() {

    private val userRemoteDataSource: UserRemoteDataSource
        get() = UserRemoteDataSource(sessionManager, RetrofitClient.getApiUserService(this))

    private val sportRemoteDataSource: SportRemoteDataSource
        get() = SportRemoteDataSource(RetrofitClient.getApiSportService(this))

    val sessionManager: SessionManager
        get() = SessionManager(this)

    val userRepository: UserRepository
        get() = UserRepository(userRemoteDataSource)

    val sportRepository: SportRepository
        get() = SportRepository(sportRemoteDataSource)
}