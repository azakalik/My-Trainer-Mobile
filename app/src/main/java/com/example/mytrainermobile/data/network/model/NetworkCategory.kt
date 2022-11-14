package com.example.mytrainermobile.data.network.model

import com.example.mytrainermobile.data.model.Category
import com.google.gson.annotations.SerializedName

class NetworkCategory (
    @SerializedName("id"     ) var id     : Int?    = null,
    @SerializedName("name"   ) var name   : String,
    @SerializedName("detail" ) var detail : String
){
    fun asModel(): Category {
        return Category(id,name,detail)
    }
}