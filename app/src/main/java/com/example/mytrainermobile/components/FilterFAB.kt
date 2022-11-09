package com.example.mytrainermobile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.example.mytrainermobile.ui.theme.DefaultBackground

@Composable
fun FilterFAB() {
    var popupControl by remember { mutableStateOf(false) }
    FloatingActionButton(
        onClick = { popupControl = true },
        contentColor = Color.Magenta,
        containerColor = DefaultBackground
    ) {
        Icon(Icons.Filled.Menu, "Localized description")
    }
    if (popupControl) {
        Popup(
            alignment = Alignment.Center,
            onDismissRequest = { popupControl = false },
//            properties = PopupProperties()
        ) {
            Box(modifier = Modifier.fillMaxSize(0.6f).border(
                width = 2.dp,
                color = Color.Magenta,
                shape = RoundedCornerShape(15.dp)
            ).background(color = DefaultBackground)){
                Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        Text(text = "Select options", color = Color.White)
                    }
                    GroupedCheckbox(
                        mItemsList = listOf(
                            "One",
                            "Two",
                            "Three"
                        )
                    )
                }
            }

        }
    }
}

@Composable
fun GroupedCheckbox(mItemsList: List<String>) {

    mItemsList.forEach { items ->
        Row(modifier = Modifier.padding(5.dp)) {
            val isChecked = remember { mutableStateOf(false) }

            Checkbox(
                checked = isChecked.value,
                onCheckedChange = { isChecked.value = it },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Magenta,
                    uncheckedColor = Color.DarkGray,
                    checkmarkColor = Color.DarkGray
                )
            )
            Text(text = items, color = Color.White)
        }
    }
}