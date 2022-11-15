package com.example.mytrainermobile.data.network.api

import ar.edu.itba.example.api.data.network.model.NetworkPagedContent
import com.example.mytrainermobile.data.network.model.NetworkCredentials
import com.example.mytrainermobile.data.network.model.NetworkRoutine
import com.example.mytrainermobile.data.network.model.NetworkToken
import com.example.mytrainermobile.data.network.model.NetworkUser
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiUserService {
    @POST("users/login")
    suspend fun login(@Body credentials: NetworkCredentials): Response<NetworkToken>

    @POST("users/logout")
    suspend fun logout(): Response<Unit>

    @GET("users/current")
    suspend fun getCurrentUser(): Response<NetworkUser>


    @GET("users/current/routines")
    suspend fun getCurrentUserRoutines(): Response<NetworkPagedContent<NetworkRoutine>>
}
