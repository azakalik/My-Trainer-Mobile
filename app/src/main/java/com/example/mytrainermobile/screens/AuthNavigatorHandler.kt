package com.example.mytrainermobile.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


sealed class AuthNavigatorItems(val route: String) {
    object Arrive : AuthNavigatorItems("arrive")
    object SignIn : AuthNavigatorItems("signIn")
    object SignUp : AuthNavigatorItems("signUp")
    object AppNavigationHandler : AuthNavigatorItems("appNavigatorHandler")
}


@Composable
fun AuthNavigatorHandler(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "signIn"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        val onNavigateToAppNavigator = {
            navController.navigate("appNavigatorHandler") {
                popUpTo(0)
            }
        }
        composable(AuthNavigatorItems.Arrive.route) { ArriveScreen(/*...*/) }
        composable(AuthNavigatorItems.SignIn.route) {
            ShowSignInScreen(onNavigateToSignUp = {
                navController.navigate(AuthNavigatorItems.SignUp.route) {
                    popUpTo(AuthNavigatorItems.SignUp.route) { inclusive = false }
                }
            }, onNavigateToAppNavigator)
        }
        composable(AuthNavigatorItems.SignUp.route) {
            ShowSignupScreen(onNavigateToSignIn = {
                navController.navigate(AuthNavigatorItems.SignIn.route) {
                    popUpTo(AuthNavigatorItems.SignIn.route) { inclusive = true }
                }
            }, onNavigateToAppNavigator)
        }
        composable(AuthNavigatorItems.AppNavigationHandler.route) { AppNavigatorHandler() }
    }
}



