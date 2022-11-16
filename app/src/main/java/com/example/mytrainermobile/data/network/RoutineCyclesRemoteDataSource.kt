package com.example.mytrainermobile.data.network

import ar.edu.itba.example.api.data.network.model.NetworkPagedContent
import com.example.mytrainermobile.data.network.api.ApiRoutineCyclesService
import com.example.mytrainermobile.data.network.model.NetworkCycle

class RoutineCyclesRemoteDataSource(
    private val routinesCyclesService: ApiRoutineCyclesService
): RemoteDataSource() {

    suspend fun getRoutinesCycles(routineId: Int) : NetworkPagedContent<NetworkCycle> {
        return handleApiResponse {
            routinesCyclesService.getRoutinesCycles(routineId)
        }
    }
}