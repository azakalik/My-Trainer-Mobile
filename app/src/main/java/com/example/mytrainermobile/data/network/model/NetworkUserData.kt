package com.example.mytrainermobile.data.network.model

import com.example.mytrainermobile.data.model.UserData
import com.google.gson.annotations.SerializedName

class NetworkUserData(
    @SerializedName("firstName")
    var firstName: String,
    @SerializedName("lastName")
    var lastName: String,
) {
    fun asModel() : UserData {
        return UserData(
            firstName = firstName,
            lastName = lastName,
        )
    }
}