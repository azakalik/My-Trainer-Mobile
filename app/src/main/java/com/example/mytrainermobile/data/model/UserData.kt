package com.example.mytrainermobile.data.model

import com.example.mytrainermobile.data.network.model.NetworkUserData

class UserData(
    var firstName: String,
    var lastName: String,
) {
    fun asNetworkModel(): NetworkUserData {
        return NetworkUserData(
            firstName = firstName,
            lastName = lastName,
        )
    }
}