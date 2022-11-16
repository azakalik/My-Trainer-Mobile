package com.example.mytrainermobile.data.network.api

import ar.edu.itba.example.api.data.network.model.NetworkPagedContent
import com.example.mytrainermobile.data.network.model.NetworkCycle
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRoutineCyclesService {

    @GET("routines/{routineId}/cycles")
    suspend fun getRoutinesCycles(@Path("routineId") routineId: Int) : Response<NetworkPagedContent<NetworkCycle>>

}