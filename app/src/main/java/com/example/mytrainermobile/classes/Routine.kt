package com.example.mytrainermobile.classes

data class Routine(
    val id: Int? = null,
    val name: String? = null,
    val creator: String,
    val category: String? = null,
    val difficulty: String? = null,
    val rating: String? = null,
    val description: String? = null,
    var isFavourite: Boolean? = false,
    val cycleIds: List<Int>
) {
    //https://kotlinlang.org/docs/classes.html#secondary-constructors
}
