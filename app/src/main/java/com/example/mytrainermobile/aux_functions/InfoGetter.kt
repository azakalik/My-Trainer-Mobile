package com.example.mytrainermobile.aux_functions

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.mytrainermobile.R

@Composable
fun getRoutineTypesList(): List<String> {
    return listOf(
        stringResource(id = R.string.arms), stringResource(id = R.string.abs), stringResource(id = R.string.back), stringResource(id = R.string.cardio), stringResource(id = R.string.chest), stringResource(id = R.string.legs), stringResource(id = R.string.mixed), stringResource(id = R.string.shoulder)
    )
}

@Composable
fun getSortOptionsList(): List<String> {
    return listOf(stringResource(id = R.string.sort_creation_date), stringResource(id = R.string.sort_rating), stringResource(id = R.string.sort_difficulty), stringResource(id = R.string.sort_category))
}