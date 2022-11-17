package com.example.mytrainermobile.screenStates

import com.example.mytrainermobile.data.model.Routine

data class RoutineUIState (
    val message:String? = null,
    val isFetching: Boolean = false,
    val routineList: List<Routine> = emptyList(),
    val showSortFAB: Boolean = false,
    val sortingBy: String = "date",
    val auxSortingBy: String = "date",
    val sortDescending: Boolean = false,
    val sortDirection: String = "asc",
    val auxSortDescending: Boolean = false,
    val directionOptions: List<String> = listOf("asc", "desc"),
    val sortOptions: List<String> = listOf("date", "score", "difficulty", "category"),
    var index: Int = 0
)