package com.example.mytrainermobile.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytrainermobile.R
import com.example.mytrainermobile.components.DefaultButton
import com.example.mytrainermobile.components.DefaultTextField
import com.example.mytrainermobile.ui.main.MainViewModel
import com.example.mytrainermobile.ui.main.errorOcurred
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme
import com.example.mytrainermobile.util.getViewModelFactory

@Composable
fun ShowSignInScreen(
    onNavigateToSignUp: () -> Unit,
    loginCallback: (String,String) -> Unit,
) {
    MyTrainerMobileTheme {
        var counter by  remember  { mutableStateOf(0) }
        counter++
        Log.d("mensajeSignIn",counter.toString())
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = DefaultBackground), contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // -------- TITLE--------------------------------------
                Text(
                    text = "My Trainer",
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 20.dp),
                    color = DefaultColor,
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold,
                )
                SignInText()

                // ---------- SIGN IN FIELDS ---------------------------
                var email by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }

                DefaultTextField(
                    value = email,
                    callback = { email = it },
                    placeholder = stringResource(id = R.string.signup_insert_email),
                    //isError = uiState.errorOcurred
                )

                DefaultTextField(
                    value = password,
                    callback = { password = it },
                    placeholder = stringResource(id = R.string.signup_insert_password),
                    //isError = uiState.errorOcurred
                )

                // ------- SIGN IN BUTTONS -----------------------------
                DefaultButton(onClick = {
                    loginCallback(email,password)
                }, text = stringResource(id = R.string.signInText))
                Button(
                    onClick = { GoToSignUp(onNavigateToSignUp) },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = DefaultBackground,
                        Color.White
                    )
                ) {
                    Text(stringResource(id = R.string.signup_goto_signup), color = Color.White)
                }

                //if (uiState.errorOcurred)
                //    Text(stringResource(id = R.string.sign_error), color = Color.Red)
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

fun GoToSignUp(onNavigateToSignUp: () -> Unit) {
    onNavigateToSignUp()
}