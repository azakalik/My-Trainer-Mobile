package com.example.mytrainermobile.classes

data class Routine(
    val id: Int,
    val name: String,
    val creator: String,
    val category: String,
    val difficulty: String,
    val rating: String,
    val description: String,
    var isFavourite: Boolean = false,
    val cycleIds: List<Int>
) {
    //https://kotlinlang.org/docs/classes.html#secondary-constructors
}
