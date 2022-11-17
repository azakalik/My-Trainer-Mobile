package com.example.mytrainermobile.data.network.api

import ar.edu.itba.example.api.data.network.model.NetworkPagedContent
import com.example.mytrainermobile.data.network.model.NetworkRating
import com.example.mytrainermobile.data.network.model.NetworkRatingContent
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiReviewService {

    @GET("reviews/{routineId}")
    suspend fun getRating(@Path("routineId") routineId: Int) : Response<NetworkPagedContent<NetworkRatingContent>>

    @POST("reviews/{routineId}")
    suspend fun putRating(@Path("routineId") routineId: Int, @Body rating: NetworkRating) :Response<Unit>
}