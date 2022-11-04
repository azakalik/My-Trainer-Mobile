package com.example.mytrainermobile.aux_functions

import com.example.mytrainermobile.R

fun pictureDecider(type: String): Int {
    return when (type) {
        "arms" -> R.drawable.arms
        "abs" -> R.drawable.abs
        "back" -> R.drawable.back
        "cardio" -> R.drawable.cardio
        "chest" -> R.drawable.chest
        "legs" -> R.drawable.legs
        "mixed" -> R.drawable.mixed
        "shoulders" -> R.drawable.shoulders
        else -> R.drawable.arms //todo improve error picture
    }
}