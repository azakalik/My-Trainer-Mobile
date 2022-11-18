package com.example.mytrainermobile.data.network

import ar.edu.itba.example.api.data.network.model.NetworkPagedContent
import com.example.mytrainermobile.data.network.api.ApiRoutineService
import com.example.mytrainermobile.data.network.model.NetworkReview
import com.example.mytrainermobile.data.network.model.NetworkRoutine

class RoutineRemoteDataSource(
    private val apiRoutineService : ApiRoutineService
): RemoteDataSource() {

    suspend fun getRoutines() : NetworkPagedContent<NetworkRoutine> {
        return handleApiResponse {
            apiRoutineService.getRoutines()
        }
    }

    suspend fun getRoutine(routineId: Int) : NetworkRoutine {
        return handleApiResponse {
            apiRoutineService.getRoutine(routineId)
        }
    }

    suspend fun getRoutinesSorted(order: String, dir: String) : NetworkPagedContent<NetworkRoutine>{
        return handleApiResponse {
            apiRoutineService.getRoutinesSorted(order,dir)
        }
    }

    suspend fun reviewRoutine(review : NetworkReview, routineId : Int){
        return handleApiResponse {
            apiRoutineService.reviewRoutine(routineId,review)
        }
    }

}