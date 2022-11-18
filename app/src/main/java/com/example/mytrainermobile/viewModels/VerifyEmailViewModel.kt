package com.example.mytrainermobile.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytrainermobile.data.network.repository.UserRepository
import com.example.mytrainermobile.screenStates.VerifyEmailState
import com.example.mytrainermobile.util.SessionManager
import kotlinx.coroutines.launch

class VerifyEmailViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {
    var uiState by mutableStateOf(VerifyEmailState())
        private set

    fun verifyEmail(email: String, code: String) = viewModelScope.launch {
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        runCatching {
            userRepository.verifyEmail(email, code)
        }.onSuccess {
            uiState = uiState.copy(
                isFetching = false,
                attemptedToVerify = true,
            )
        }.onFailure { e ->
            // Handle the error and notify the UI when appropriate.
            uiState = uiState.copy(
                message = e.message,
                isFetching = false
            )
        }
    }
}