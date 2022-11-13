package com.example.mytrainermobile.screenStates

data class SortFABState(
    val showSortFAB: Boolean = false,
    val sortingBy: String = "",
    val auxSortingBy: String = "",
    val sortDescending: Boolean = false,
    val auxSortDescending: Boolean = false,
    val sortOptions: List<String> = listOf("creationDate", "rating", "difficulty", "category")
)