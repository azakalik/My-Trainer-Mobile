package com.example.mytrainermobile.screens

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytrainermobile.components.RoutineBox
import com.example.mytrainermobile.components.TitleBox
import com.example.mytrainermobile.components.TitleForSection


@Preview ( showBackground = true )
@Composable
fun HomeScreen(){
//    val configuration = LocalConfiguration.current
//    if ( configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
//        configuration.
//    } else {
//
//    }

    val l = listOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12,13,14)

    Scaffold(modifier = Modifier.fillMaxSize(), backgroundColor = Color.Black) {
        Column( modifier = Modifier.fillMaxSize() ) {
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp))
            TitleForSection()
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(40.dp))
            Text(text = "Glad to have you back",color = Color.White,modifier = Modifier.padding(start = 15.dp), fontSize = 20.sp)
            Text(text = "James Smith", color = Color.White,modifier = Modifier.padding(start = 20.dp), style = TextStyle(fontWeight = FontWeight.Bold), fontSize = 30.sp )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(40.dp))
            TitleBox(title = "Last Routines", startPadding = 10.dp)
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)){
                LazyRow(modifier = Modifier.fillMaxSize().padding(15.dp)){
                    items(l.size) {
                        num -> RoutineBox(routineName = "pepe", routineType = "pecho")
                    }
                }
            }
            TitleBox(title = "Recommended", startPadding = 10.dp)
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)){
                LazyRow(modifier = Modifier.fillMaxSize().padding(15.dp)){
                    items(l.size) {
                            num -> RoutineBox(routineName = "pepe", routineType = "pecho")
                    }
                }
            }

        }
    }
}

