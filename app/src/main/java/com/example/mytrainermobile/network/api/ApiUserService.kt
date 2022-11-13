package com.example.mytrainermobile.network.api

import com.example.mytrainermobile.network.model.NetworkCredentials
import com.example.mytrainermobile.network.model.NetworkToken
import com.example.mytrainermobile.network.model.NetworkUser
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
}
