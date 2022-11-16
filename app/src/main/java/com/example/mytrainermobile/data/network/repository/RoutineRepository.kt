package com.example.mytrainermobile.data.network.repository


import com.example.mytrainermobile.data.model.Routine
import com.example.mytrainermobile.data.network.RoutineRemoteDataSource
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock


class RoutineRepository(private val remoteDataSource : RoutineRemoteDataSource) {

    private val routinesMutex = Mutex()
    private var routines: List<Routine> = emptyList()

    suspend fun getRoutines(refresh: Boolean = false): List<Routine> {
        if( refresh || routines.isEmpty()){
            val result = remoteDataSource.getRoutines()
            routinesMutex.withLock {
                this.routines = result.content.map { it.asModel() }
            }
        }
        return routinesMutex.withLock { this.routines }
    }

    suspend fun getRoutinesBySearch(query: String): List<Routine> {
        val allRoutines = remoteDataSource.getRoutines()
        routinesMutex.withLock {
            this.routines = allRoutines.content.filter{ it.name.toLowerCase().equals(query.toLowerCase())}.map { it.asModel() }
        }
        return routinesMutex.withLock { this.routines }
    }

    suspend fun getRoutine(routineId: Int) : Routine {
        return remoteDataSource.getRoutine(routineId).asModel()
    }

}

