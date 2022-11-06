package com.example.mytrainermobile.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mytrainermobile.components.ThisBottomAppBar
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ShowProfileScreen(
    onNavigateToHome: () -> Unit,
    onNavigateToFavourites: () -> Unit,
    onNavigateToExplore: () -> Unit,
    onNavigateToProfile: () -> Unit
) {
    MyTrainerMobileTheme() {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(DefaultBackground),
            bottomBar = { ThisBottomAppBar(onNavigateToHome, onNavigateToFavourites, onNavigateToExplore, onNavigateToProfile) },
        ) {
            Text("Profile Screen")
        }
    }
}