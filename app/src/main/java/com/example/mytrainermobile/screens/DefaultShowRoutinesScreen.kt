package com.example.mytrainermobile.screens

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mytrainermobile.classes.Routine
import com.example.mytrainermobile.components.*
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme

//This class is only meant to be used by explore, favourites and my routines
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DefaultShowRoutinesScreen(
    title: String,
    onNavigateToStartWorkout: () -> Unit
) {
    MyTrainerMobileTheme() {
        val list = listOf<Routine>(
            Routine(1, "rutina chest", "chest"),
            Routine(2, "rutina back", "back"),
            Routine(3, "rutina legs", "legs"),
            Routine(3, "rutina cardio", "cardio"),
            Routine(1, "rutina chest", "chest"),
            Routine(2, "rutina back", "back"),
            Routine(3, "rutina legs", "legs"),
            Routine(3, "rutina cardio", "cardio"),
            Routine(1, "rutina chest", "chest"),
            Routine(2, "rutina back", "back"),
            Routine(3, "rutina legs", "legs"),
            Routine(3, "rutina cardio", "cardio"),
            Routine(1, "rutina chest", "chest"),
            Routine(2, "rutina back", "back"),
            Routine(3, "rutina legs", "legs"),
            Routine(3, "rutina cardio", "cardio"),
            Routine(1, "rutina chest", "chest"),
            Routine(2, "rutina back", "back"),
            Routine(3, "rutina legs", "legs"),
            Routine(3, "rutina cardio", "cardio"),
            Routine(1, "rutina chest", "chest"),
            Routine(2, "rutina back", "back"),
            Routine(3, "rutina legs", "legs"),
            Routine(3, "rutina cardio", "cardio"),
        )

        Column(modifier = Modifier.fillMaxWidth()) {
            val configuration = LocalConfiguration.current
            when (configuration.orientation) {
                Configuration.ORIENTATION_PORTRAIT -> {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.23f),
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            TitleForSection()
                        }
                        TitleBox(
                            title = title
                        )
                    }
                }
                else -> {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.2f),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TitleBox(
                            title = title
                        )
                        TitleForSection()
                        Spacer(modifier = Modifier.padding(0.dp, 0.dp, 25.dp, 0.dp))
                    }
                }
            }
            LazyVerticalGrid(

                modifier = Modifier
                    .fillMaxSize()
                    .padding(),
                contentPadding = PaddingValues(5.dp, 0.dp, 5.dp, 80.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalArrangement = Arrangement.Center,
                columns = GridCells.Adaptive(150.dp),
                content = {
                    items(list.size) { idx ->
                        list[idx].name?.let { it1 ->
                            list[idx].type?.let { it2 ->
                                RoutineBox(
                                    routineName = it1,
                                    routineType = it2,
                                    onNavigateToStartWorkout
                                )
                            }
                        }
                    }
                })
        }

    }
}