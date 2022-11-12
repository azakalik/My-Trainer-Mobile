package com.example.mytrainermobile.screenStates

data class RSigningInUserUIState(
    val userName: String = "",
    val password: String = "",
    val isLoggedIn: Boolean = false,
    val errorMessage: String? = null
) {
}