package com.example.mytrainermobile.screens

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytrainermobile.R
import com.example.mytrainermobile.classes.Routine
import com.example.mytrainermobile.components.NavBottomBar
import com.example.mytrainermobile.components.RoutineBox
import com.example.mytrainermobile.components.TitleBox
import com.example.mytrainermobile.components.TitleForSection
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    MyTrainerMobileTheme() {
        val list = listOf<Routine>(
            Routine(1, "r1", "cardio"),
            Routine(2, "r2", "back"),
            Routine(3, "r3", "legs"),
            Routine(3, "r3", "cardio"),
            Routine(3, "r3", "mixed"),
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

        Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = { NavBottomBar() }) {
            Column(modifier = Modifier.fillMaxSize()) {
                val configuration = LocalConfiguration.current
                when(configuration.orientation) {
                    Configuration.ORIENTATION_PORTRAIT -> {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.3f),
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            TitleForSection()

                            TitleBox(title = stringResource(id = R.string.explore), 30.dp, 0.2f, 0.5f)
                        }
                    }
                    else -> {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.2f), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                            TitleBox(title = stringResource(id = R.string.explore), 30.dp, 0.5f, 0.3f)
                            TitleForSection()
                            Spacer(modifier = Modifier.padding(0.dp, 0.dp, 25.dp, 0.dp))
                        }
                    }
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                )

                LazyVerticalGrid(
                    modifier = Modifier.fillMaxSize(),
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
//                TitleBox(title = "Last Routines", startPadding = 10.dp)
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                ) {
//                    LazyRow(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(15.dp)
//                    ) {
//                        items(l.size) { num ->
//                            RoutineBox(routineName = "pepe", routineType = "pecho")
//                        }
//                    }
//                }
//                TitleBox(title = "Recommended", startPadding = 10.dp)
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                ) {
//                    LazyRow(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(15.dp)
//                    ) {
//                        items(l.size) { num ->
//                            RoutineBox(routineName = "pepe", routineType = "pecho")
//                        }
//                    }
//                }

            }
        }
    }
//    val configuration = LocalConfiguration.current
//    if ( configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
//        configuration.
//    } else {
//
//    }

}

