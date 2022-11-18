package com.example.mytrainermobile.data.network.model

import com.example.mytrainermobile.data.model.Review
import com.google.gson.annotations.SerializedName

class NetworkReview(
    @SerializedName("score"      ) var score      : Int,
    @SerializedName("review"   )  var review   : String,
) {
    fun asModel() : Review {
        return Review(
            score = score,
            review = review,
        )
    }
}