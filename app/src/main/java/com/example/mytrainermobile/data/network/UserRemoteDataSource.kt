package com.example.mytrainermobile.data.network

import com.example.mytrainermobile.data.network.api.ApiUserService
import com.example.mytrainermobile.data.network.model.NetworkCredentials
import com.example.mytrainermobile.data.network.model.NetworkUser
import com.example.mytrainermobile.data.network.model.NetworkUserData
import com.example.mytrainermobile.util.SessionManager

class UserRemoteDataSource(
    private val sessionManager: SessionManager,
    private val apiUserService: ApiUserService
) : RemoteDataSource() {

    suspend fun login(username: String, password: String) {
        val response = handleApiResponse {
            apiUserService.login(NetworkCredentials(username, password))
        }
        sessionManager.saveAuthToken(response.token)
    }

    suspend fun logout() {
        handleApiResponse { apiUserService.logout() }
        sessionManager.removeAuthToken()
    }

    suspend fun getCurrentUser() : NetworkUser {
        return handleApiResponse { apiUserService.getCurrentUser() }
    }

    suspend fun modifyUser(name: String, surname: String){
        handleApiResponse {
            apiUserService.modifyUser(NetworkUserData(name, surname))
        }
    }
}