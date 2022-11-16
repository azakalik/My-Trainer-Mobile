package com.example.mytrainermobile.data.network.model

import com.example.mytrainermobile.data.model.Exercise
import com.google.gson.annotations.SerializedName
import java.util.*

class NetworkExercise(
    @SerializedName("id"     ) var id     : Int,
    @SerializedName("name"   ) var name   : String,
    @SerializedName("detail" ) var detail : String? = null,
    @SerializedName("type"   ) var type   : String,
    @SerializedName("date"   ) var date   : Date?    = null,
    @SerializedName("order"  ) var order  : Int
) {
    fun asModel() : Exercise {
        return Exercise(
            id = id,
            name = name,
            detail = detail,
            type = type,
            date = date,
            order = order
        )
    }
}