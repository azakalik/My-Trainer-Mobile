package com.example.mytrainermobile.data.network.api


import ar.edu.itba.example.api.data.network.model.NetworkPagedContent
import com.example.mytrainermobile.data.network.model.NetworkRoutine
import retrofit2.Response
import retrofit2.http.*

interface ApiFavouriteService {

    @GET("favourites")
    suspend fun getFavourites() : Response<NetworkPagedContent<NetworkRoutine>>

    @POST("favourites/{routineId}")
    suspend fun makeFavourite(@Path("routineId") routineId: Int) : Response<Unit>

    @DELETE("favourites/{routineId}")
    suspend fun removeFavourite(@Path("routineId") routineId: Int) : Response<Unit>

    @GET("users/current/routines")
    suspend fun getFavouriteRoutinesSorted(@Query("orderBy") orderBy: String, @Query("direction") direction: String) : Response<NetworkPagedContent<NetworkRoutine>>

}