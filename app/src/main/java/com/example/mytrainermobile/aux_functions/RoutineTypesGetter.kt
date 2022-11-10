package com.example.mytrainermobile.aux_functions

import androidx.compose.runtime.Composable

@Composable
fun getRoutineTypesList(): List<String> {
    return listOf(
        "Arms", "Abs", "Back", "Cardio", "Chest", "Legs", "Mixed", "Shoulder"
    )
}