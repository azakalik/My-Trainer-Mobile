package com.example.mytrainermobile.data.network

import ar.edu.itba.example.api.data.network.model.NetworkPagedContent
import com.example.mytrainermobile.data.network.api.ApiCycleExercisesService
import com.example.mytrainermobile.data.network.model.NetworkCycleExercise

class CycleExercisesRemoteDataSource(
    private val cyclesExercisesService: ApiCycleExercisesService
):RemoteDataSource() {

    suspend fun getCycleExercises(cycleId: Int) : NetworkPagedContent<NetworkCycleExercise> {
        return handleApiResponse {
            cyclesExercisesService.getCycleExercises(cycleId)
        }
    }
}