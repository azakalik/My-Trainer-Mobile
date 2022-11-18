package com.example.mytrainermobile.screenStates

data class SignUpState(
    val isFetching: Boolean = false,
    val message: String? = null,
)

val SignUpState.errorOcurred: Boolean get() = message != null