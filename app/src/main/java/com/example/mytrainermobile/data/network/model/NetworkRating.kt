package com.example.mytrainermobile.data.network.model

import com.google.gson.annotations.SerializedName

data class NetworkRating(
    @SerializedName("score"  ) var score  : Int?    = null,
    @SerializedName("review" ) var review : String? = null
)
