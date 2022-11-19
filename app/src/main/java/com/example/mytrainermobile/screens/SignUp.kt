package com.example.mytrainermobile.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.example.mytrainermobile.screenStates.SignUpState
import com.example.mytrainermobile.screenStates.errorOcurred
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme
import com.example.mytrainermobile.util.getViewModelFactory
import com.example.mytrainermobile.viewModels.SignUpViewModel

@Composable
fun ShowSignupScreen(
    onNavigateToVerifyEmail: () -> Unit,
    viewModel: SignUpViewModel = viewModel(factory = getViewModelFactory())
) {
    val uiState = viewModel.uiState
    MyTrainerMobileTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DefaultBackground)
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(state = ScrollState(initial = 0))
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = stringResource(id = R.string.title),
                        color = DefaultColor,
                        fontSize = 64.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    SignupText()
                }
                ShowSignUpForm({ username: String, email: String, password: String, firstName: String, lastName: String ->
                    viewModel.signup(
                        username,
                        email,
                        password,
                        firstName,
                        lastName
                    )
                }, onNavigateToVerifyEmail, uiState)
            }
        }
    }
}

@Composable
fun SignupText() {
    Text(
        text = stringResource(id = R.string.signUpText),
        style = Typography().h3.copy(fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 10.dp),
        color = Color.White
    )
}

@Composable
fun ShowSignUpForm(
    callback: (String, String, String, String, String) -> Unit,
    onNavigateToVerifyEmail: () -> Unit,
    uiState: SignUpState
) {
    var step by remember { mutableStateOf(0) }
    var showPopup by remember { mutableStateOf(false) }
    var username by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var email2 by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var password2 by remember { mutableStateOf("") }

    if (step == 0) {
        DefaultTextField(
            value = username,
            callback = { username = it },
            placeholder = stringResource(id = R.string.signup_insert_username),
            isError = uiState.errorOcurred
        )
        DefaultTextField(
            value = firstName,
            callback = { firstName = it },
            placeholder = stringResource(id = R.string.signup_insert_name),
            isError = uiState.errorOcurred
        )
        DefaultTextField(
            value = lastName,
            callback = { lastName = it },
            placeholder = stringResource(id = R.string.signup_insert_surname),
            isError = uiState.errorOcurred
        )
        DefaultButton({ step = 1 }, stringResource(R.string.signup_continue))
    }
    if (step == 1) {
        DefaultTextField(
            value = email,
            callback = { email = it },
            placeholder = stringResource(id = R.string.signup_insert_email),
            isError = uiState.errorOcurred
        )
        DefaultTextField(
            value = email2,
            callback = { email2 = it },
            placeholder = stringResource(id = R.string.signup_reinsert_email),
            isError = uiState.errorOcurred
        )
        DefaultTextField(
            value = password,
            callback = { password = it },
            placeholder = stringResource(id = R.string.signup_insert_password),
            isError = uiState.errorOcurred
        )
        DefaultTextField(
            value = password2,
            callback = { password2 = it },
            placeholder = stringResource(id = R.string.signup_reinsert_password),
            isError = uiState.errorOcurred
        )
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            SecondaryButton(onClick = { step = 0 }, text = stringResource(id = R.string.signup_goback))
            DefaultButton({
                callback(username, email, password, firstName, lastName); showPopup = true
            }, stringResource(id = R.string.signUpText))
        }
    }
    if (uiState.errorOcurred){
        Row {
            Text(text = stringResource(id = R.string.formerror), color = Color.Red)
            showPopup = false
            if (email != email2){
                Text(text = stringResource(id = R.string.emailerror), color = Color.Red)
            } else if (password != password2){
                Text(text = stringResource(R.string.passerror), color = Color.Red)
            } else if (email.isBlank() || password.isBlank()){
                Text(text = stringResource(id = R.string.fielderror), color = Color.Red)
            } else if (username.isBlank() || firstName.isBlank() || lastName.isBlank()){
                Text(text = stringResource(id = R.string.fielderror), color = Color.Red)
                step = 0
            } else {
                Text(text = uiState.message!!, color = Color.Red)
            }
        }
        //Text(text = "Correct the error and try to sign up again.", color = Color.Red)
    }
    ShowSignupCompletedPopup(onNavigateToSignIn = onNavigateToVerifyEmail, showPopup = showPopup)
}

fun GoToSignIn(onNavigateToSignIn: () -> Unit) {
    onNavigateToSignIn()
}

@Composable
fun ShowSignupCompletedPopup(onNavigateToSignIn: () -> Unit, showPopup: Boolean) {
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
                            stringResource(id = R.string.createsucces),
                            color = Color.White,
                            fontSize = 24.sp,
                            modifier = Modifier.padding(15.dp)
                        )
                        DefaultButton(
                            onClick = { GoToSignIn(onNavigateToSignIn) },
                            stringResource(id = R.string.verify)
                        )
                    }
                }
            }
        }
    }

}