package com.example.mytrainermobile.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytrainermobile.data.network.repository.UserRepository
import com.example.mytrainermobile.screenStates.SignUpState
import com.example.mytrainermobile.util.SessionManager
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {
    var uiState by mutableStateOf(SignUpState())
        private set

    fun signup(
        username: String,
        email: String,
        password: String,
        firstName: String,
        lastName: String
    ) = viewModelScope.launch {
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        runCatching {
            userRepository.signup(
                username = username,
                email = email,
                password = password,
                firstName = firstName,
                lastName = lastName
            )
        }.onSuccess {
            uiState = uiState.copy(
                isFetching = false,
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