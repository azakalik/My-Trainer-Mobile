package com.example.mytrainermobile.screenStates

data class SortFABState(
    val showSortFAB: Boolean = false,
    val sortingBy: String = "creationDate",
    val auxSortingBy: String = "creationDate",
    val sortDescending: Boolean = false,
    val auxSortDescending: Boolean = false,
    val sortOptions: List<String> = listOf("creationDate", "rating", "difficulty", "category")
)