package com.example.mytrainermobile.data.network.repository

import com.example.mytrainermobile.data.model.Cycle
import com.example.mytrainermobile.data.model.UserRating
import com.example.mytrainermobile.data.network.RemoteRoutineReviewDataSource
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class ReviewRepository(private val reviewDataSource: RemoteRoutineReviewDataSource) {


    private var mtx = Mutex()
    private var reviewList = emptyList<UserRating>()



    suspend fun getUserRating(userName : String,routineId: Int? = null): Int?{
        if ( reviewList.isEmpty() ){
                loadReviews(routineId!!)
        }
        for ( r in reviewList){
            if ( r.userName == userName)
                return r.rating
        }
        return null
    }




    suspend fun loadReviews(routineId: Int, refresh: Boolean = false) : Unit {
        if(refresh || reviewList.isEmpty()) {
            val result = reviewDataSource.getReviews(routineId)
            mtx.withLock {
                this.reviewList = result.content.map { it.asModel() }
            }
        }
    }

    suspend fun getRoutineRating(routineId: Int? = null) : Double{
        if ( reviewList.isEmpty() ){
            loadReviews(routineId!!)
        }
        var sum = 0.0
        mtx.withLock { this.reviewList.forEach{rating -> sum += rating.rating!! } }
        return sum / reviewList.size
    }




}