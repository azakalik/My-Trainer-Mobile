package com.example.mytrainermobile.data.network.repository

import com.example.mytrainermobile.data.model.Routine
import com.example.mytrainermobile.data.network.FavouriteRemoteDataSource
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class FavouriteRepository(private val favouriteRemoteDataSource: FavouriteRemoteDataSource) {



    private val routinesMutex = Mutex()
    private var routines: List<Routine> = emptyList()

    suspend fun getRoutines(refresh: Boolean = false): List<Routine> {
        if( refresh || routines.isEmpty()){
            val result = favouriteRemoteDataSource.getFavourites()
            routinesMutex.withLock {
                this.routines = result.content.map { it.asModel() }
            }
        }
        return routinesMutex.withLock { this.routines }
    }

    suspend fun getRoutinesBySearch(query: String): List<Routine> {
        val allRoutines = favouriteRemoteDataSource.getFavourites()
        routinesMutex.withLock {
            this.routines = allRoutines.content.filter{ it.name.toLowerCase().equals(query.toLowerCase())}.map { it.asModel() }
        }
        return routinesMutex.withLock { this.routines }
    }

}