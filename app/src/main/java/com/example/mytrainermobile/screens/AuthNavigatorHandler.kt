package com.example.mytrainermobile.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytrainermobile.ui.main.MainUiState


sealed class AuthNavigatorItems(val route: String) {
    object Verify : AuthNavigatorItems("verifyEmail")
    object SignIn : AuthNavigatorItems("signIn")
    object SignUp : AuthNavigatorItems("signUp")
}


@Composable
fun AuthNavigatorHandler(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "signIn",
    loginCallback: (String, String) -> Unit,
    uiState: MainUiState,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(AuthNavigatorItems.SignIn.route) {
            ShowSignInScreen(
                onNavigateToSignUp = {
                    navController.navigate(AuthNavigatorItems.SignUp.route) {
                        popUpTo(AuthNavigatorItems.SignUp.route) { inclusive = false }
                    }
                }, onNavigateToVerifyEmail = {
                    navController.navigate(AuthNavigatorItems.Verify.route)
                }, loginCallback, uiState
            )
        }
        composable(AuthNavigatorItems.SignUp.route) {
            ShowSignupScreen(
                onNavigateToVerifyEmail = {
                    navController.navigate(AuthNavigatorItems.Verify.route)
                })

        }
        composable(AuthNavigatorItems.Verify.route) {
            VerifyEmailScreen(onNavigateToSignIn = {
                navController.navigate(AuthNavigatorItems.SignIn.route)
            })
        }
    }
}




