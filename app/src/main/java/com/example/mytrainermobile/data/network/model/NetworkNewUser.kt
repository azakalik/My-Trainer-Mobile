package com.example.mytrainermobile.data.network.model

import com.google.gson.annotations.SerializedName


data class NetworkNewUser (

    @SerializedName("username"  ) var username  : String,
    @SerializedName("password"  ) var password  : String,
    @SerializedName("firstName" ) var firstName : String,
    @SerializedName("lastName"  ) var lastName  : String,
    @SerializedName("gender"    ) var gender    : String? = null,
    @SerializedName("birthdate" ) var birthdate : Int?    = null,
    @SerializedName("email"     ) var email     : String,
    @SerializedName("phone"     ) var phone     : String? = null,
    @SerializedName("avatarUrl" ) var avatarUrl : String? = null,
    @SerializedName("metadata"  ) var metadata  : String? = null

)