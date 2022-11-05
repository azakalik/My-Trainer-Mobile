package com.example.mytrainermobile.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytrainermobile.classes.Routine
import com.example.mytrainermobile.components.RoutineBox
import com.example.mytrainermobile.components.TitleBox
import com.example.mytrainermobile.components.TitleForSection
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme

@Preview
@Composable
fun HomeScreen(){
    DefaultShowRoutinesScreen(title = "Home screen")
}


//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Preview(showBackground = true)
//@Composable
//fun HomeScreen() {
//    MyTrainerMobileTheme() {
//        val list = listOf<Routine>(
//            Routine(1, "r1", "cardio"),
//            Routine(2, "r2", "back"),
//            Routine(3, "r3", "legs"),
//            Routine(3, "r3", "cardio"),
//            Routine(3, "r3", "mixed"),
//            Routine(3, "r3", "Legs"),
//            Routine(3, "r3", "Legs"),
//            Routine(3, "r3", "Legs"),
//            Routine(3, "r3", "Legs"),
//            Routine(3, "r3", "Legs"),
//            Routine(3, "r3", "Legs"),
//            Routine(3, "r3", "Legs"),
//            Routine(3, "r3", "Legs"),
//            Routine(3, "r3", "Legs"),
//            Routine(3, "r3", "Legs"),
//            Routine(3, "r3", "Legs"),
//            Routine(3, "r3", "Legs"),
//            Routine(3, "r3", "Legs")
//        )
//
//        Scaffold(modifier = Modifier.fillMaxSize()) {
//            Column(modifier = Modifier.fillMaxSize()) {
//                Spacer(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(20.dp)
//                )
//                TitleForSection()
//                Spacer(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(40.dp)
//                )
//                Text(
//                    text = "Glad to have you back",
//                    color = Color.White,
//                    modifier = Modifier.padding(start = 15.dp),
//                    fontSize = 20.sp
//                )
//                Text(
//                    text = "James Smith",
//                    color = Color.White,
//                    modifier = Modifier.padding(start = 20.dp),
//                    style = TextStyle(fontWeight = FontWeight.Bold),
//                    fontSize = 30.sp
//                )
//                Spacer(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(40.dp)
//                )
//                LazyVerticalGrid(
//                    modifier = Modifier.fillMaxSize(),
//                    horizontalArrangement = Arrangement.SpaceAround,
//                    verticalArrangement = Arrangement.Center,
//                    columns = GridCells.Adaptive(150.dp),
//                    content = {
//                        items(list.size) { idx ->
//                            RoutineBox(
//                                routineName = list[idx].name,
//                                routineType = list[idx].type
//                            )
//                        }
//                    })
////                TitleBox(title = "Last Routines", startPadding = 10.dp)
////                Box(
////                    modifier = Modifier
////                        .fillMaxWidth()
////                ) {
////                    LazyRow(
////                        modifier = Modifier
////                            .fillMaxSize()
////                            .padding(15.dp)
////                    ) {
////                        items(l.size) { num ->
////                            RoutineBox(routineName = "pepe", routineType = "pecho")
////                        }
////                    }
////                }
////                TitleBox(title = "Recommended", startPadding = 10.dp)
////                Box(
////                    modifier = Modifier
////                        .fillMaxWidth()
////                ) {
////                    LazyRow(
////                        modifier = Modifier
////                            .fillMaxSize()
////                            .padding(15.dp)
////                    ) {
////                        items(l.size) { num ->
////                            RoutineBox(routineName = "pepe", routineType = "pecho")
////                        }
////                    }
////                }
//
//            }
//        }
//    }
////    val configuration = LocalConfiguration.current
////    if ( configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
////        configuration.
////    } else {
////
////    }
//
//}

