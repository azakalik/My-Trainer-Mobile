package com.example.mytrainermobile.screenStates

data class VerifyEmailState(
    val isFetching: Boolean = false,
    val attemptedToVerify: Boolean = false,
    val message: String? = null,
)

val VerifyEmailState.errorOcurred: Boolean get() = message != null