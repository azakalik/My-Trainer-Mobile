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

    suspend fun makeFavourite(routineId: Int){
        routinesMutex.withLock {
            favouriteRemoteDataSource.makeFavourite(routineId)
        }
        //recargo las rutinas favoritas
        getRoutines(refresh = true)
    }

    suspend fun removeFavourite(routineId: Int){
        //if ( routines.stream().noneMatch { r-> r.id == routineId} )
        //    return
        routinesMutex.withLock {
            favouriteRemoteDataSource.removeFavourite(routineId)
        }
        getRoutines(refresh = true)
    }

    suspend fun isFavourited(routineId:Int) : Boolean{
        return favouriteRemoteDataSource.getFavourites().content.stream().map { r -> r.asModel() }.anyMatch{ r -> r.id == routineId}
    }

    suspend fun getFavouriteRoutinesSorted(order: String, dir: String): List<Routine> {
        val filteredRoutines = favouriteRemoteDataSource.getFavouriteRoutinesSorted(order, dir)
        routinesMutex.withLock {
            this.routines = filteredRoutines.content.map { it.asModel() }
        }
        return routinesMutex.withLock { this.routines }
    }

}