package com.example.mytrainermobile.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mytrainermobile.classes.Routine
import com.example.mytrainermobile.R
import com.example.mytrainermobile.components.RoutineBox
import com.example.mytrainermobile.components.TitleBox
import com.example.mytrainermobile.components.TitleForSection


@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun FavouritesView() {

    val list = listOf<Routine>(
        Routine(1, "r1", "Chest"),
        Routine(2, "r2", "Back"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs")
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.blackMainTheme))
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f), verticalArrangement = Arrangement.SpaceEvenly
            ) {
                TitleForSection()
                TitleBox(title = stringResource(id = R.string.myfavourites), 80.dp)
            }
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalArrangement = Arrangement.Center,
                columns = GridCells.Fixed(2),
                content = {
                    items(list.size) { idx ->
                        RoutineBox(
                            routineName = list[idx].name,
                            routineType = list[idx].type
                        )
                    }
                })
        }
    }
}

