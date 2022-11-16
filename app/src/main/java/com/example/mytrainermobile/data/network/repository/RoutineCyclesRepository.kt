package com.example.mytrainermobile.data.network.repository

import com.example.mytrainermobile.data.model.Cycle
import com.example.mytrainermobile.data.network.RoutineCyclesRemoteDataSource
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class RoutineCyclesRepository(
    private val remoteDataSource: RoutineCyclesRemoteDataSource
) {
    private var routineCyclesMutex = Mutex()
    private var routineCycles: List<Cycle> = emptyList()

    suspend fun getRoutineCycles(routineId: Int, refresh: Boolean = false) : List<Cycle> {
        if(refresh || routineCycles.isEmpty()) {
            val result = remoteDataSource.getRoutinesCycles(routineId)

            routineCyclesMutex.withLock {
                this.routineCycles = result.content.map { it.asModel() }
            }
        }

        return routineCyclesMutex.withLock { this.routineCycles }
    }
}