package com.example.mytrainermobile.data.model

import com.example.mytrainermobile.data.network.model.NetworkRating

data class UserRating (
    val rating:Int? = null,
    val userName:String? = null
){
    fun asNetworkModel() : NetworkRating{
        //solo nos interesa serializar el rating
        return NetworkRating( score = rating, review = "")
    }
}