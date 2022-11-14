package com.example.mytrainermobile.components

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mytrainermobile.data.model.BottomNavigationData
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor

@Composable
fun ThisBottomAppBar(navController: NavController, showBottomBar: Boolean) {


    val items = listOf(
        BottomNavigationData.MyRoutines,
        BottomNavigationData.Favourites,
        BottomNavigationData.Explore,
        BottomNavigationData.Profile
    )

    if (showBottomBar) {
        NavigationBar(containerColor = DefaultBackground) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                BottomNavigationItem(
                    unselectedContentColor = Color.White,
                    selectedContentColor = DefaultColor,
                    icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                    label = { Text(text = item.title) },
                    alwaysShowLabel = true,
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { screenRoute ->
                                popUpTo(screenRoute) {
                                    saveState = true
                                    inclusive = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                )
            }
        }
    }
}