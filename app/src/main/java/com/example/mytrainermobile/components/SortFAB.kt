package com.example.mytrainermobile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.example.mytrainermobile.R
import com.example.mytrainermobile.aux_functions.getRoutineTypesList
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor

@Composable
fun SortFAB() {
    var popupControl by remember { mutableStateOf(false) }
    FloatingActionButton(
        onClick = { popupControl = !popupControl },
        contentColor = DefaultColor,
        containerColor = DefaultBackground
    ) {
        Icon(Icons.Filled.Menu, stringResource(id = R.string.fab_name))
    }
    if (popupControl) {
        Popup(
            alignment = Alignment.Center,
            onDismissRequest = { popupControl = !popupControl },
//            properties = PopupProperties()
        ) {
            Box(modifier = Modifier
                .fillMaxWidth(0.6f)
                .border(
                    width = 2.dp,
                    color = DefaultColor,
                    shape = RoundedCornerShape(15.dp)
                )
                .background(color = DefaultBackground)){
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        Text(text = stringResource(id = R.string.fab_name), color = Color.White, modifier = Modifier.padding(10.dp))
                    }
                    ShowDropDownMenu()
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                        DefaultButton(onClick = { popupControl = false }, text = stringResource(id = R.string.cancel))
                        DefaultButton(onClick = { popupControl = false }, text = stringResource(id = R.string.accept))
                    }
//                    GroupedCheckbox(
//                        mItemsList = getRoutineTypesList()
//                    )
//                    Row(Modifier.fillMaxWidth().padding(vertical = 5.dp), horizontalArrangement = Arrangement.SpaceEvenly){
//                        DefaultButton(onClick = { popupControl = false }, text = stringResource(id = R.string.cancel))
//                        DefaultButton(onClick = { popupControl = !popupControl; filter() }, text = stringResource(id = R.string.accept))
//                    }
                }
            }

        }
    }
}

@Composable
fun GroupedCheckbox(mItemsList: List<String>) {

    mItemsList.forEach { items ->
        Row(modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {
            val isChecked = remember { mutableStateOf(false) }

            Checkbox(
                checked = isChecked.value,
                onCheckedChange = { isChecked.value = it },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = DefaultColor,
                    uncheckedColor = DefaultBackground,
                    checkmarkColor = DefaultBackground
                )
            )
            Text(text = items, color = Color.White)
        }
    }
}

@Composable
fun ShowDropDownMenu(){
    var expanded by remember { mutableStateOf(false)}
    val options = listOf("Creation date", "Rating", "Difficulty", "Category")
    var currentValue by remember { mutableStateOf(options[0])}

    Column() {
        Row(modifier = Modifier.clickable { expanded = !expanded }) {
            Text(text = currentValue, color = Color.White)
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "Select sort options", tint = Color.White)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = {expanded = false}) {
            options.forEach {
                DropdownMenuItem(text = { Text(it) }, onClick = { currentValue = it; expanded = false })
            }
        }
    }
}
