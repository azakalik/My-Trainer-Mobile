package com.example.mytrainermobile.ui.main


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytrainermobile.screens.AppNavigatorHandler
import com.example.mytrainermobile.screens.AuthNavigatorHandler
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme
import com.example.mytrainermobile.util.getViewModelFactory
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTrainerMobileTheme {
                val mainViewModel: MainViewModel = viewModel(factory = getViewModelFactory())
                val systemUiController = rememberSystemUiController()
                systemUiController.setSystemBarsColor(
                    color = androidx.compose.ui.graphics.Color.Black
                )
                if (mainViewModel.uiState.isAuthenticated) {
                    AppNavigatorHandler()
                } else {
                    AuthNavigatorHandler(
                        loginCallback = { name: String, password: String ->
                            mainViewModel.login(
                                name,
                                password
                            )
                        },
                        uiState = mainViewModel.uiState
                    )
                }
            }
        }
    }
}
