package com.example.mytrainermobile.data.network.api


import ar.edu.itba.example.api.data.network.model.NetworkPagedContent
import com.example.mytrainermobile.data.network.model.NetworkRoutine
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiFavouriteService {

    @GET("favourites")
    suspend fun getFavourites() : Response<NetworkPagedContent<NetworkRoutine>>

    @POST("favourites/{routineId}")
    suspend fun markFavourite(@Path("routineId") routineId: Int) : Response<Unit>

    @DELETE("favourites/{routineId}")
    suspend fun removeFavourtie(@Path("routineId") routineId: Int) : Response<Unit>

}