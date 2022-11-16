package com.example.mytrainermobile.data.model

import com.example.mytrainermobile.data.network.model.NetworkCycle



data class Cycle(
    var id: Int,
    var name: String,
    var detail: String? = null,
    var type: String,
    var order: Int,
    var repetitions: Int
) {
    fun asNetworkModel() : NetworkCycle {
        return NetworkCycle(
            id = id,
            name = name,
            detail = detail,
            type = type,
            order = order,
            repetitions = repetitions
        )
    }
}