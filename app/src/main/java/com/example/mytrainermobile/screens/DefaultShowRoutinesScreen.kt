package com.example.mytrainermobile.screens

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.example.mytrainermobile.R
import com.example.mytrainermobile.components.*
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme
import com.example.mytrainermobile.viewModels.DefaultViewModelInterface

//This class is only meant to be used by explore, favourites and my routines
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DefaultShowRoutinesScreen(
    title: String,
    onNavigateToStartWorkout: (id: Int) -> Unit,
    viewModel: DefaultViewModelInterface,
    showSort: Boolean = true
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    MyTrainerMobileTheme() {
        val bigScreenMode = viewModel.getScreenMode(screenWidth)
        val routineList = viewModel.getRoutineList()
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
                            TitleForSection(bigScreenMode)
                        }
                        if (showSort) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                TitleBox(
                                    title = title,
                                    bigScreenMode
                                )
                                IconButton(onClick = {
                                    viewModel.toggleShowSortButton()
                                }) {
                                    androidx.compose.material.Icon(
                                        painter = painterResource(R.drawable.ic_baseline_sort_24),
                                        contentDescription = "Sort",
                                        tint = DefaultColor,
                                        modifier = Modifier.padding(10.dp).size(viewModel.getSortSize(screenWidth))
                                    )
                                }
                            }
                        } else {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                TitleBox(
                                    title = title,
                                    bigScreenMode
                                )
                            }
                        }

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
                            title = title,
                            bigScreenMode
                        )
                        TitleForSection(bigScreenMode)
                        if(showSort){
                            IconButton(onClick = {
                                viewModel.toggleShowSortButton()
                            }) {
                                androidx.compose.material.Icon(
                                    painter = painterResource(R.drawable.ic_baseline_sort_24),
                                    contentDescription = "Sort",
                                    tint = DefaultColor,
                                    modifier = Modifier.padding(10.dp).size(viewModel.getSortSize(screenWidth))
                                )
                            }
                        }
                    }
                }
            }
            if(bigScreenMode){
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(),
                    contentPadding = PaddingValues(5.dp, 0.dp, 5.dp, 80.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalArrangement = Arrangement.Center,
                    columns = GridCells.Adaptive(400.dp),
                    content = {
                        items(routineList.size) { idx ->
                            RoutineBox(
                                routineList[idx],
                                onNavigateToStartWorkout,
                                bigScreenMode
                            )
                        }
                    }
                )
            } else {
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
                                onNavigateToStartWorkout,
                                bigScreenMode
                            )
                        }
                    }
                )
            }

            if (viewModel.getState().showSortButton) {
                Popup(
                    alignment = Alignment.Center,
                    onDismissRequest = { viewModel.toggleShowSortButton() },
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .border(
                                width = 2.dp,
                                color = DefaultColor,
                                shape = RoundedCornerShape(15.dp)
                            )
                            .background(
                                color = DefaultBackground,
                                shape = RoundedCornerShape(15.dp)
                            )
                    ) {
                        Column(
                            Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            // --------- POPUP TITLE --------------------------------
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = stringResource(id = R.string.fab_name),
                                    color = Color.White,
                                    modifier = Modifier.padding(10.dp),
                                    fontSize = 20.sp
                                )
                            }
                            ShowRadioButtons(viewModel)
                            // ---------- POPUP BUTTONS ----------------------------
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                DefaultButton(
                                    onClick = { viewModel.toggleShowSortButton(); viewModel.unSaveChanges() },
                                    text = stringResource(id = R.string.cancel)
                                )
                                DefaultButton(
                                    onClick = {
                                        viewModel.toggleShowSortButton(); viewModel.saveChanges()
                                    },
                                    text = stringResource(id = R.string.accept)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}