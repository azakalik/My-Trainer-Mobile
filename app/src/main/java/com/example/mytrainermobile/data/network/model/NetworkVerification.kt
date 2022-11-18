package com.example.mytrainermobile.data.network.model

import com.google.gson.annotations.SerializedName

data class NetworkVerification (

    @SerializedName("email" ) var email : String? = null,
    @SerializedName("code"  ) var code  : String? = null

)