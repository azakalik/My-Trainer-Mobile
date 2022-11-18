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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytrainermobile.R
import com.example.mytrainermobile.components.DefaultButton
import com.example.mytrainermobile.components.DefaultTextField
import com.example.mytrainermobile.components.SecondaryButton
import com.example.mytrainermobile.ui.main.MainUiState
import com.example.mytrainermobile.ui.main.errorOcurred
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme

@Composable
fun VerifyEmailScreen(
    onNavigateToSignIn: () -> Unit,
    callback: (String, String) -> Unit,
    uiState: MainUiState
) {
    MyTrainerMobileTheme {
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
                VerifyEmailText()

                // ---------- SIGN IN FIELDS ---------------------------
                var email by remember { mutableStateOf("") }
                var code by remember { mutableStateOf("") }

                DefaultTextField(
                    value = email,
                    callback = { email = it },
                    placeholder = stringResource(id = R.string.signup_insert_email),
                    isError = uiState.errorOcurred
                )

                DefaultTextField(
                    value = code,
                    callback = { code = it },
                    placeholder = "Insert code *",
                    isError = uiState.errorOcurred
                )

                // ------- SIGN IN BUTTONS -----------------------------
                DefaultButton(onClick = {
                    callback(email, code)
                }, text = "Verify email")
                SecondaryButton(
                    onClick = { onNavigateToSignIn() },
                    "Go back to sign in"
                )

                if (uiState.errorOcurred)
                    Text(stringResource(id = R.string.sign_error), color = Color.Red)
            }
        }
    }
}

@Composable
fun VerifyEmailText() {
    Text(
        text = "Verify email",
        style = Typography().h3.copy(fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(bottom = 20.dp),
        color = Color.White
    )
}