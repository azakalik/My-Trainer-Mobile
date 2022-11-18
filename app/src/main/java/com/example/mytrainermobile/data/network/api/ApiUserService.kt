package com.example.mytrainermobile.data.network.api

import ar.edu.itba.example.api.data.network.model.NetworkPagedContent
import com.example.mytrainermobile.data.network.model.*
import retrofit2.Response
import retrofit2.http.*

interface ApiUserService {
    @POST("users/login")
    suspend fun login(@Body credentials: NetworkCredentials): Response<NetworkToken>

    @POST("users")
    suspend fun signup(@Body user: NetworkNewUser): Response<Unit>

    @POST("users/verify_email")
    suspend fun verifyEmail(@Body verification: NetworkVerification): Response<Unit>

    @POST("users/logout")
    suspend fun logout(): Response<Unit>

    @GET("users/current")
    suspend fun getCurrentUser(): Response<NetworkUser>

    @GET("users/current/routines")
    suspend fun getCurrentUserRoutines(): Response<NetworkPagedContent<NetworkRoutine>>

    @GET("users/current/routines")
    suspend fun getCurrentUserRoutinesSorted(@Query("orderBy") orderBy: String, @Query("direction") direction: String) : Response<NetworkPagedContent<NetworkRoutine>>

    @PUT("users/current")
    suspend fun modifyUser(@Body newName : NetworkUserData): Response<NetworkUser>
}
