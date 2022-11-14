package com.example.mytrainermobile.data.model

import com.example.mytrainermobile.data.network.model.NetworkCategory
import com.example.mytrainermobile.data.network.model.NetworkRoutine
import com.example.mytrainermobile.data.network.model.NetworkUser

data class Routine(
    val id: Int,
    val name: String,
    val detail: String? = null,
    val score: Int? = null,
    val difficulty: String? = null,
    val user: NetworkUser? = null,
    val category: NetworkCategory,
    var isFavourite: Boolean = false,
) {
    fun asNetworkModel(): NetworkRoutine {
        return NetworkRoutine(
            id = id,
            name = name,
            detail = detail,
            score = score,
            difficulty = difficulty,
            user = user,
            category = category
        )
    }
}
