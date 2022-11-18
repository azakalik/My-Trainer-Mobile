package com.example.mytrainermobile.data.network.repository

import com.example.mytrainermobile.data.model.User
import com.example.mytrainermobile.data.network.UserRemoteDataSource
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class UserRepository(
    private val remoteDataSource: UserRemoteDataSource
) {

    // Mutex to make writes to cached values thread-safe.
    private val currentUserMutex = Mutex()
    // Cache of the current user got from the network.
    private var currentUser: User? = null

    suspend fun login(username: String, password: String) {
        remoteDataSource.login(username, password)
    }

    suspend fun signup(username: String, email: String, password: String, firstName: String, lastName: String) {
        remoteDataSource.signup(username = username, email = email, password = password, firstName = firstName, lastName = lastName)
    }

    suspend fun verifyEmail(email: String, code: String) {
        remoteDataSource.verifyEmail(email, code)
    }

    suspend fun logout() {
        remoteDataSource.logout()
    }

    suspend fun getCurrentUser(refresh: Boolean) : User? {
        if (refresh || currentUser == null) {
            val result = remoteDataSource.getCurrentUser()
            // Thread-safe write to latestNews
            currentUserMutex.withLock {
                this.currentUser = result.asModel()
            }
        }

        return currentUserMutex.withLock { this.currentUser }
    }

    suspend fun modifyUser(name: String, surname: String){
        remoteDataSource.modifyUser(name, surname)
    }
}

