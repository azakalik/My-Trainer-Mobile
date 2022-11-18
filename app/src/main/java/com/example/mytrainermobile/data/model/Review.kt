package com.example.mytrainermobile.data.model

import com.example.mytrainermobile.data.network.model.NetworkReview

data class Review(
    var score: Int,
    var review: String,
) {
    fun asNetworkModel(): NetworkReview {
        return NetworkReview(
            score = score,
            review = review,

            )
    }
}