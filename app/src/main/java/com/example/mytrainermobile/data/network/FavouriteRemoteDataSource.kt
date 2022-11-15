package com.example.mytrainermobile.data.network

import ar.edu.itba.example.api.data.network.model.NetworkPagedContent
import com.example.mytrainermobile.data.network.api.ApiFavouriteService
import com.example.mytrainermobile.data.network.model.NetworkRoutine

class FavouriteRemoteDataSource (
    private val apiFavouriteService : ApiFavouriteService
) : RemoteDataSource(){

    suspend fun getFavourites() : NetworkPagedContent<NetworkRoutine> {
        return handleApiResponse {
            apiFavouriteService.getFavourites()
        }
    }

    suspend fun toggleFavourite(routineId: Int){
        return handleApiResponse {
            apiFavouriteService.markFavourite(routineId)
        }
    }

    suspend fun removeFavourite(routineId: Int){
        return handleApiResponse {
            apiFavouriteService.removeFavourtie(routineId)
        }
    }
}