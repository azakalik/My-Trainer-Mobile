package com.example.mytrainermobile.data.network

import ar.edu.itba.example.api.data.network.model.NetworkPagedContent
import com.example.mytrainermobile.data.model.UserRating
import com.example.mytrainermobile.data.network.api.ApiReviewService
import com.example.mytrainermobile.data.network.model.NetworkRatingContent

class RemoteRoutineReviewDataSource(private val reviewApi: ApiReviewService): RemoteDataSource() {


    suspend fun getReviews(routineId: Int) : NetworkPagedContent<NetworkRatingContent> {
        return handleApiResponse {
            reviewApi.getRating(routineId)
        }
    }


    suspend fun putRating(routineId: Int,userRating: UserRating) {
        return handleApiResponse {
            reviewApi.putRating(routineId,userRating.asNetworkModel())
        }
    }
}