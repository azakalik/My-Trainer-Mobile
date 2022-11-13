package com.example.mytrainermobile.network.model

import com.google.gson.annotations.SerializedName

data class NetworkCredentials (

    @SerializedName("username")
    var username : String,
    @SerializedName("password")
    var password : String
)
