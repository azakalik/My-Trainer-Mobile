package com.example.mytrainermobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytrainermobile.R
import com.example.mytrainermobile.components.DefaultButton
import com.example.mytrainermobile.components.DefaultTextField
import com.example.mytrainermobile.components.SecondaryButton
import com.example.mytrainermobile.screenStates.errorOcurred
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme
import com.example.mytrainermobile.util.getViewModelFactory
import com.example.mytrainermobile.viewModels.VerifyEmailViewModel

@Composable
fun VerifyEmailScreen(
    onNavigateToSignIn: () -> Unit,
    viewModel: VerifyEmailViewModel = viewModel(factory = getViewModelFactory())
) {
    val uiState = viewModel.uiState
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

                DefaultButton(
                    onClick = { viewModel.verifyEmail(email, code) },
                    text = "Verify email"
                )
                SecondaryButton(
                    onClick = { onNavigateToSignIn() },
                    "Go to sign in"
                )

                if (uiState.errorOcurred)
                    Text(stringResource(id = R.string.sign_error), color = Color.Red)
                else {
                    ShowVerifyCompletedPopup(
                        onNavigateToSignIn = onNavigateToSignIn,
                        showPopup = !uiState.errorOcurred
                    )
                }
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

@Composable
fun ShowVerifyCompletedPopup(onNavigateToSignIn: () -> Unit, showPopup: Boolean) {
    if (showPopup) {
        Popup(
            alignment = Alignment.Center,
            properties = PopupProperties(
                focusable = true,
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            Row(
                Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.5f)
                        .fillMaxWidth(0.8f)
                        .border(
                            width = 2.dp,
                            color = DefaultColor,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .background(
                            color = DefaultBackground,
                            shape = RoundedCornerShape(15.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "User created succesfully, press the button below to sign in and start using the app",
                            color = Color.White,
                            fontSize = 24.sp,
                            modifier = Modifier.padding(15.dp)
                        )
                        DefaultButton(
                            onClick = { GoToSignIn(onNavigateToSignIn) },
                            "Sign in"
                        )
                    }
                }
            }
        }
    }
}