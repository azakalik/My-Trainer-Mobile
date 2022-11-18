package com.example.mytrainermobile.data.network.api

import ar.edu.itba.example.api.data.network.model.NetworkPagedContent
import com.example.mytrainermobile.data.network.model.NetworkReview
import com.example.mytrainermobile.data.network.model.NetworkRoutine
import retrofit2.Response
import retrofit2.http.*

interface ApiRoutineService {

    @GET("routines")
    suspend fun getRoutines() : Response<NetworkPagedContent<NetworkRoutine>>

    @GET("routines/{routineId}")
    suspend fun getRoutine(@Path("routineId") routineId: Int) : Response<NetworkRoutine>

    @GET("routines")
    suspend fun getRoutinesSorted(@Query("orderBy") orderBy: String, @Query("direction") direction: String) : Response<NetworkPagedContent<NetworkRoutine>>

    @POST("reviews/{routineId}")
    suspend fun reviewRoutine(@Path("routineId") routineId: Int, @Body review : NetworkReview) : Response<Unit>
}

