package com.example.mytrainermobile.screens

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.util.Log
import android.view.Surface
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.mytrainermobile.components.RoutineBox
import com.example.mytrainermobile.components.SortFAB
import com.example.mytrainermobile.components.TitleBox
import com.example.mytrainermobile.components.TitleForSection
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme
import com.example.mytrainermobile.viewModels.DefaultViewModelInterface
import com.example.mytrainermobile.viewModels.ToggleFavouriteViewModelnterface

//This class is only meant to be used by explore, favourites and my routines
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DefaultShowRoutinesScreen(
    title: String,
    onNavigateToStartWorkout: (id: Int) -> Unit,
    viewModel: DefaultViewModelInterface,

) {
    var counter by  remember  { mutableStateOf(0) }
    val scaffoldState = rememberScaffoldState()
    counter++
    Log.d("mensaje",counter.toString())
    MyTrainerMobileTheme() {
        viewModel.loadRoutines()
        val routineList = viewModel.getRoutineList()
        /*Scaffold(
            scaffoldState = scaffoldState,

            floatingActionButton = {
                SortFAB(
                    true,
                    viewModel = viewModel,
                )
            },
        ) {*/
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
                        items(routineList.size) { idx ->
                            RoutineBox(
                                routineList[idx],
                                { /* favouriteMaker.makeFavourite(routineList[idx].id)*/ },
                                { /*favouriteMaker.removeFavourite(routineList[idx].id) */ },
                                onNavigateToStartWorkout
                            )
                        }
                    })
            }
        }
   // }
}