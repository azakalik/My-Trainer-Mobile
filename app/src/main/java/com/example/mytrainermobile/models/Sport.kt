package com.example.mytrainermobile.models

import com.example.mytrainermobile.network.model.NetworkSport

class Sport(
    var id: Int? = null,
    var name: String,
    var detail: String? = null
) {
    fun asNetworkModel(): NetworkSport {
        return NetworkSport(
            id = id,
            name = name,
            detail = detail
        )
    }
}
