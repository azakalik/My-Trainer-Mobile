package com.example.mytrainermobile.network

import com.example.mytrainermobile.network.api.ApiSportService
import ar.edu.itba.example.api.data.network.model.NetworkPagedContent
import com.example.mytrainermobile.network.RemoteDataSource
import com.example.mytrainermobile.network.model.NetworkSport

class SportRemoteDataSource(
    private val apiSportService: ApiSportService
) : RemoteDataSource() {

    suspend fun getSports() : NetworkPagedContent<NetworkSport> {
        return handleApiResponse {
            apiSportService.getSports()
        }
    }

    suspend fun getSport(sportId: Int) : NetworkSport {
        return handleApiResponse {
            apiSportService.getSport(sportId)
        }
    }

    suspend fun addSport(sport: NetworkSport) : NetworkSport {
        return handleApiResponse {
            apiSportService.addSport(sport)
        }
    }

    suspend fun modifySport(sport: NetworkSport) : NetworkSport {
        return handleApiResponse {
            apiSportService.modifySport(sport.id!!, sport)
        }
    }

    suspend fun deleteSport(sportId: Int){
        handleApiResponse {
            apiSportService.deleteSport(sportId)
        }
    }
}