package com.example.mytrainermobile.network.data

import com.example.mytrainermobile.network.models.UserToken
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("/api/users/login")
    suspend fun loginUser(username:String,password:String) : Response<UserToken>
}