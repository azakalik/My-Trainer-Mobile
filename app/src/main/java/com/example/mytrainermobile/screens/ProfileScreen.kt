package com.example.mytrainermobile.screens

import android.annotation.SuppressLint
import android.app.Activity
import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytrainermobile.R
import com.example.mytrainermobile.components.DefaultButton
import com.example.mytrainermobile.components.DefaultTextField
import com.example.mytrainermobile.components.TitleBox
import com.example.mytrainermobile.components.TitleForSection
import com.example.mytrainermobile.ui.main.MainViewModel
import com.example.mytrainermobile.ui.theme.DefaultColor
import com.example.mytrainermobile.util.getViewModelFactory

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ShowProfileScreen(
    viewModel: MainViewModel = viewModel(factory = getViewModelFactory())
) {
    val uiState = viewModel.uiState
    val activity = (LocalContext.current as? Activity)
    var editing by remember { mutableStateOf(false) }
    var firstEntry by  remember  { mutableStateOf(true) }
    if (firstEntry) {
        viewModel.getCurrentUser()
        firstEntry = false
    }

    val user = uiState.currentUser
    Column {
        val configuration = LocalConfiguration.current
        when (configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.23f),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        TitleForSection()
                    }
                    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                        TitleBox(
                            title = stringResource(id = R.string.profile)
                        )
                        IconButton(onClick = {
                            editing = true
                        }) {
                            Icon(
                                modifier = Modifier.size(35.dp),
                                imageVector = Icons.Filled.Settings,
                                contentDescription = "Settings",
                                tint = DefaultColor,
                            )
                        }
                    }
                }
            }
            else -> {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.2f),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TitleBox(
                        title = stringResource(id = R.string.profile)
                    )
                    TitleForSection()
                }
            }
        }
        if(viewModel.uiState.message == null) {
            if (uiState.isAuthenticated) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    if (!editing) {
                        if (user != null) {
                            Text(
                                text = stringResource(
                                    R.string.nameandsurname,
                                    user.firstName,
                                    user.lastName
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                                fontSize = 30.sp
                            )
                            Text(
                                text = stringResource(R.string.username, user.username),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                                fontSize = 30.sp
                            )
                            Text(
                                text = stringResource(R.string.usermail, user.email),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                                fontSize = 30.sp
                            )
                            Spacer(modifier = Modifier.padding(10.dp))
                            DefaultButton(
                                onClick = { viewModel.logout(); activity?.finish() },
                                text = stringResource(R.string.logout)
                            )
                        }
                    } else {
                        Column(
                            modifier = Modifier.padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            var name by remember { mutableStateOf("") }
                            var surname by remember { mutableStateOf("") }
                            Text(
                                text = stringResource(id = R.string.editprofile),
                                color = Color.White,
                                fontSize = 20.sp
                            )
                            if (user != null) {
                                DefaultTextField(
                                    value = name,
                                    //placeholder = { Text(text = user.firstName) },
                                    placeholder = stringResource(R.string.name),
                                    callback = {
                                        name = it
                                    }
                                )
                                DefaultTextField(
                                    value = surname,
                                    //placeholder = { Text(text = user.lastName) },
                                    placeholder = stringResource(R.string.lastname),
                                    callback = {
                                        surname = it
                                    }
                                )
                            }
                            Row(
                                horizontalArrangement = Arrangement.SpaceAround,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                DefaultButton(
                                    onClick = { editing = false },
                                    text = stringResource(id = R.string.cancel)
                                )
                                DefaultButton(onClick = {
                                    viewModel.modifyUser(name.toString(), surname.toString())
                                    editing = false
                                }, text = stringResource(id = R.string.save))
                            }
                        }
                    }
                }
            } else
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.profileError),
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }
        }else{
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = viewModel.uiState.message!!,
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        }
    }
}