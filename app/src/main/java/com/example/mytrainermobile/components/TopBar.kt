package com.example.mytrainermobile.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mytrainermobile.ui.theme.DefaultColor

@Composable
fun TopBar(title: String) {
    TopAppBar(backgroundColor = Color.Black, contentColor = DefaultColor, title = {
        TitleWorkout(title = title)
    }, navigationIcon =
    {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                modifier = Modifier.size(33.dp),
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = "back arrow"
            )
        }
    })
}

@Composable
fun TitleWorkout(title: String) {
    Text(modifier = Modifier.fillMaxWidth(), text = title)
}