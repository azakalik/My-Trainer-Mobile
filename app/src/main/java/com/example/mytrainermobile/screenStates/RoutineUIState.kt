package com.example.mytrainermobile.screenStates

import com.example.mytrainermobile.data.model.Routine

data class RoutineUIState (
    val message:String? = null,
    val isFetching: Boolean = false,
    val routineList: List<Routine> = emptyList(),
    val showSortFAB: Boolean = false,
    val sortingBy: String = "creationDate",
    val auxSortingBy: String = "creationDate",
    val sortDescending: Boolean = false,
    val sortDirection: String = "asc",
    val auxSortDescending: Boolean = false,
    val directionOptions: List<String> = listOf("asc", "des"),
    val sortOptions: List<String> = listOf("creationDate", "score", "difficulty", "category"),
    var index: Int = 0
)