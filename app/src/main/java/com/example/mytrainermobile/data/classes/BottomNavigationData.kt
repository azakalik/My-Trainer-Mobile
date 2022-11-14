package com.example.mytrainermobile.data.classes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationData(val title: String, val icon: ImageVector, val route:String) {
    object MyRoutines: BottomNavigationData("My Routines", Icons.Filled.Home,"myRoutines")
    object Favourites: BottomNavigationData("Favourites",Icons.Filled.Favorite,"favourites")
    object Explore: BottomNavigationData("Explore",Icons.Filled.Search,"explore")
    object Profile: BottomNavigationData("Me",Icons.Filled.Person,"profile")
}