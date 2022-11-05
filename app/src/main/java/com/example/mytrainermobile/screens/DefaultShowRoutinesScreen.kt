package com.example.mytrainermobile.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mytrainermobile.R
import com.example.mytrainermobile.classes.Routine
import com.example.mytrainermobile.components.RoutineBox
import com.example.mytrainermobile.components.TitleBox
import com.example.mytrainermobile.components.TitleForSection
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme

//This class is only meant to be used by home, favourites and my routines
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DefaultShowRoutinesScreen(title: String) {
    MyTrainerMobileTheme() {
        val list = listOf<Routine>(
            Routine(1, "r1", "chest"),
            Routine(2, "r2", "back"),
            Routine(3, "r3", "legs"),
            Routine(3, "r3", "cardio"),
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
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(DefaultBackground),
            bottomBar = { ThisBottomAppBar() },
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.3f), verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    TitleForSection()
                    TitleBox(title = title, 80.dp)
                }
                LazyVerticalGrid(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalArrangement = Arrangement.Center,
                    columns = GridCells.Adaptive(150.dp),
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
}

@Composable
fun ThisBottomAppBar(){
    BottomAppBar() {

    }
}