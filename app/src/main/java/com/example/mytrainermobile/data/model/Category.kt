package com.example.mytrainermobile.data.model

import com.example.mytrainermobile.data.network.model.NetworkCategory

class Category(
    var id     : Int?    = null,
    var name   : String,
    var detail : String = ""
) {
    fun asNetworkModel(): NetworkCategory{
        return NetworkCategory(id,name,detail)
    }
}