package com.example.mytrainermobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mytrainermobile.components.DefaultTextField
import com.example.mytrainermobile.R
import com.example.mytrainermobile.components.DefaultButton
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme

@Preview(showBackground = true)
@Composable
fun ShowSignInScreen() {
    MyTrainerMobileTheme() {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = DefaultBackground), contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SignInText()
                ShowSignInForm()
            }
        }
    }
}

@Composable
fun SignInText() {
    Text(
        text = stringResource(id = R.string.signInText),
        style = Typography().h3.copy(fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(bottom = 20.dp),
        color = Color.White
    )
}

@Composable
fun ShowSignInForm() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    DefaultTextField(
        value = email,
        callback = { email = it },
        placeholder = stringResource(id = R.string.signup_insert_email)
    )

    DefaultTextField(
        value = password,
        callback = { password = it },
        placeholder = stringResource(id = R.string.signup_insert_password)
    )

    DefaultButton(onClick = { SignIn() }, text = stringResource(id = R.string.signInText))
    DefaultButton(onClick = { GoToSignUp() }, text = stringResource(id = R.string.signup_goto_signup))
}

fun SignIn() {/*TODO*/}

fun GoToSignUp() {}