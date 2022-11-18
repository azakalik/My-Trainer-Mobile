package com.example.mytrainermobile.components

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.mytrainermobile.ui.theme.DefaultSecondary

@Composable

fun DefaultButton(onClick: () -> Unit, text: String, enabled: Boolean = true) {
    Button(onClick = onClick, enabled = enabled) {
        Text(text = text, color = Color.White)
    }
}

@Composable
fun SecondaryButton(onClick: () -> Unit, text: String) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = DefaultSecondary)
    ) {
        Text(text = text, color = Color.White)
    }
}