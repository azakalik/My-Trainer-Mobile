package com.example.mytrainermobile.data.network.api

import ar.edu.itba.example.api.data.network.model.NetworkPagedContent
import com.example.mytrainermobile.data.network.model.NetworkCycleExercise
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCycleExercisesService {
    @GET("cycles/{cycleId}/exercises")
    suspend fun getCycleExercises(@Path("cycleId") cycleId: Int) : Response<NetworkPagedContent<NetworkCycleExercise>>
}