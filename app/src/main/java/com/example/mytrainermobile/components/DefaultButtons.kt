package com.example.mytrainermobile.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun DefaultButton(onClick: ()->Unit, text: String, enabled: Boolean = true){
    Button(onClick = onClick, enabled = enabled) {
        Text(text = text, color = Color.White)
    }
}