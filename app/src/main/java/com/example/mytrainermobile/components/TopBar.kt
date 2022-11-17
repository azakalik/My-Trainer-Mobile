package com.example.mytrainermobile.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor

@Composable
fun TopBar(title: String) {
    TopAppBar(backgroundColor = DefaultBackground, contentColor = DefaultColor, title = {
        Text(modifier = Modifier.fillMaxWidth(), text = title)
    })
}