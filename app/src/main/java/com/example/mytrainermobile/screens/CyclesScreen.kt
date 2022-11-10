package com.example.mytrainermobile.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.mytrainermobile.components.CyclesCard
import     androidx.compose.material.*
import androidx.compose.ui.Alignment

@Preview (showBackground = true)
@Composable
fun CyclesScreen(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.DarkGray,
        topBar = { TopBar("Routine Cycles") }) {
        CyclesBody(pad = it)

    }
}

@Composable
fun CyclesBody(pad: PaddingValues){
    Column(modifier = Modifier.padding(pad).fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceEvenly) {

        CyclesCard("Cycle 1")

        CyclesCard("Cycle 2")

        CyclesCard("Cycle 3")
        
    }

}



