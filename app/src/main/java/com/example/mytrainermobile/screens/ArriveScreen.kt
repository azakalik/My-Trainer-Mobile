package com.example.mytrainermobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytrainermobile.R

@Composable
fun ArriveScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.blackMainTheme)),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "My Trainer", color = Color.Magenta, fontSize = 60.sp)
        Text(
            text = stringResource(id = R.string.introScreenMessage),
            color = Color.White,
            fontSize = 30.sp
        )
        Button(
            onClick = { /*TODO enviar a pagina correspondiente*/ },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta),
            modifier = Modifier.fillMaxWidth(0.5F)
        ) {
            Text(text = stringResource(id = R.string.signInText), fontSize = 30.sp)
        }
        Button(
            onClick = { /*TODO enviar a pagina correspondiente*/ },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta),
            modifier = Modifier.fillMaxWidth(0.5F)
        ) {
            Text(
                text = stringResource(id = R.string.signUpText),
                color = Color.White,
                fontSize = 30.sp
            )
        }
    }
}