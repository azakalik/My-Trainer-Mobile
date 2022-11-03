package com.example.mytrainermobile.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DefaultTextField(value: String, callback: (String) -> Unit, placeholder: String) {
    OutlinedTextField(
        value = value,
        placeholder = { Text(placeholder) },
        onValueChange = callback,
        modifier = Modifier.padding(vertical = 5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.White,
            errorBorderColor = Color.Red,
        )
    )
}