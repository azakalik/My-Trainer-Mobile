package com.example.mytrainermobile.data.network.model

import ar.edu.itba.example.api.data.model.User
import com.example.mytrainermobile.data.model.UserRating
import com.google.gson.annotations.SerializedName


data class NetworkRatingContent (

    @SerializedName("id"     ) var id     : Int?    = null,
    @SerializedName("date"   ) var date   : Int?    = null,
    @SerializedName("score"  ) var score  : Int?    = null,
    @SerializedName("review" ) var review : String? = null,
    @SerializedName("user"   ) var user   : NetworkUserRating?   = null

){
    fun asModel() : UserRating{
        return UserRating( rating = score, userName = user?.username)
    }
}