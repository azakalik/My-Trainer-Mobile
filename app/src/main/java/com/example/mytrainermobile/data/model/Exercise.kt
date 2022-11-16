package com.example.mytrainermobile.data.model

import com.example.mytrainermobile.data.network.model.NetworkExercise
import java.util.*

//todo ver si cambiamos o no la logica de metadata

class Exercise(
    var id: Int,
    var name: String,
    var detail: String? = null,
    var type: String,
    var date: Date? = null,
    var order: Int
) {
    fun asNetworkModel(): NetworkExercise {
        return NetworkExercise (
            id = id,
            name = name,
            detail = detail,
            type = type,
            date = date,
            order = order
        )
    }
}