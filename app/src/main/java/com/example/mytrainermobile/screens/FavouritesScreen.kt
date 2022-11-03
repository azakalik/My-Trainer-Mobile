package com.example.mytrainermobile.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mytrainermobile.classes.Routine
import com.example.mytrainermobile.R
import com.example.mytrainermobile.components.TitleBox
import com.example.mytrainermobile.components.TitleForSection


@OptIn(ExperimentalFoundationApi::class)
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
                TitleBox(title = "Favourites", 80.dp)
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

@Composable
fun RoutineBox(routineName: String, routineType: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable {  /*TODO*/ },
        elevation = 10.dp,
        shape = RoundedCornerShape(15.dp)
    ) {
        Box(modifier = Modifier.height(90.dp)) {
            Image(
                painter = painterResource(id = R.drawable.arms),
                contentDescription = "image",
                contentScale = ContentScale.FillBounds
            )

        }
    }
}