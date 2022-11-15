package com.example.mytrainermobile.data.network.repository

import com.example.mytrainermobile.data.model.Routine
import com.example.mytrainermobile.data.network.FavouriteRemoteDataSource
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class FavouriteRepository(
    private val remoteDataSource: FavouriteRemoteDataSource
) {
    private val favouriteMutex = Mutex()
    private var favouriteRoutines: List<Routine> = emptyList()

    suspend fun getFavourites(): List<Routine>{
        val result = remoteDataSource.getFavourites()
        favouriteMutex.withLock {
            this.favouriteRoutines = result.content.map { it.asModel() }
        }
        return favouriteMutex.withLock { this.favouriteRoutines }
    }

    suspend fun toggleFavourite(routineId: Int){
        remoteDataSource.toggleFavourite(routineId)
        favouriteMutex.withLock {
            this.favouriteRoutines = emptyList()
        }
    }

    suspend fun removeFavourite(routineId: Int){
        remoteDataSource.removeFavourite(routineId)
        favouriteMutex.withLock {
            this.favouriteRoutines = emptyList()
        }
    }
}