package com.example.mytrainermobile.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun DefaultButton(onClick: ()->Unit, text: String){
    Button(onClick = onClick, /*colors = ButtonDefaults.buttonColors(backgroundColor = DefaultColor)*/) {
        Text(text = text)
    }
}