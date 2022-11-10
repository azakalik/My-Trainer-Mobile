package com.example.mytrainermobile.viewModelStates

data class SigningInUserUIState(
    val userName: String = "",
    val password: String = "",
    val isLoggedIn: Boolean = false,
    val errorMessage: String? = null
) {
}