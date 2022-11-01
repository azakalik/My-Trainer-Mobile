package com.example.mytrainermobile.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.example.mytrainermobile.R

@Preview(showBackground = true)
@Composable
fun ShowSignupScreen(){
    Box(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier
            .verticalScroll(state = ScrollState(initial = 0)), horizontalAlignment = Alignment.CenterHorizontally){
//            Image(
//                painter = painterResource(id = R.drawable.arms),
//                contentDescription = ""/*TODO*/,
//            )
            SignupText()
            ShowForm()
        }
    }
}

@Composable
fun SignupText(){
    Text(text = "Sign up",
        style = Typography().h3.copy(fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(bottom = 10.dp)
    )
}

@Composable
fun ShowForm() {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var email2 by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var password2 by remember { mutableStateOf("") }

    SignUpTextField(value = name, callback = {name = it}, placeholder = "Insert name" )
    SignUpTextField(value = surname, callback = {surname = it}, placeholder = "Insert surname" )
    SignUpTextField(value = email, callback = {email = it}, placeholder = "Insert email" )
    SignUpTextField(value = email2, callback = {email2 = it}, placeholder = "Reinsert email" )
    SignUpTextField(value = password, callback = {password = it}, placeholder = "Insert password" )
    SignUpTextField(value = password2, callback = {password2 = it}, placeholder = "Reinsert password" )


    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
        Button(onClick = { Clear() }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)) {
            Text("Clear", color = Color.Magenta)
        }
        Button(onClick = { SignUp() }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta )) {
            Text("Sign up")
        }
    }
    Button(onClick = { GoToSignIn()}, colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)) {
        Text("Go to sign in", color = Color.Black)
    }
        //aca iria el datepicker


}

@Composable
fun SignUpTextField(value: String, callback: (String) -> Unit, placeholder: String){
    OutlinedTextField(value = value, placeholder = { Text(placeholder)}, onValueChange = callback, modifier = Modifier.padding(vertical = 5.dp), colors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = Magenta))
}

fun SignUp(){}

fun Clear(){}

fun GoToSignIn(){}