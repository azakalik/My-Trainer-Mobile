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
import com.example.mytrainermobile.classes.Routine
import com.example.mytrainermobile.components.RoutineBox
import com.example.mytrainermobile.components.ThisBottomAppBar
import com.example.mytrainermobile.components.TitleBox
import com.example.mytrainermobile.components.TitleForSection
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme

//This class is only meant to be used by explore, favourites and my routines
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DefaultShowRoutinesScreen(title: String, onNavigateToMyRoutines: () -> Unit,
                              onNavigateToFavourites: () -> Unit,
                              onNavigateToExplore: () -> Unit,
                              onNavigateToProfile: () -> Unit) {
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
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(DefaultBackground),
            bottomBar = { ThisBottomAppBar(onNavigateToMyRoutines, onNavigateToFavourites, onNavigateToExplore, onNavigateToProfile) },
        ) {
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
                            TitleForSection()
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