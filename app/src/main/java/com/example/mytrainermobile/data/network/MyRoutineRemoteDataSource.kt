package com.example.mytrainermobile.data.network

import ar.edu.itba.example.api.data.network.model.NetworkPagedContent
import com.example.mytrainermobile.data.network.api.ApiUserService
import com.example.mytrainermobile.data.network.model.NetworkRoutine

class MyRoutineRemoteDataSource(private val apiUserService: ApiUserService): RemoteDataSource() {

    suspend fun getRoutines() : NetworkPagedContent<NetworkRoutine> {
        return handleApiResponse {
            apiUserService.getCurrentUserRoutines()
        }
    }

    suspend fun getCurrentUserRoutinesSorted(order: String, dir: String) : NetworkPagedContent<NetworkRoutine>{
        return handleApiResponse {
            apiUserService.getCurrentUserRoutinesSorted(order,dir)
        }
    }

}