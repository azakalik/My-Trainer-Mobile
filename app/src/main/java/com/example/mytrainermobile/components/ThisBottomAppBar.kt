package com.example.mytrainermobile.components

import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.example.mytrainermobile.ui.theme.DefaultBackground

@Composable
fun ThisBottomAppBar(
    onNavigateToMyRoutines: () -> Unit,
    onNavigateToFavourites: () -> Unit,
    onNavigateToExplore: () -> Unit,
    onNavigateToProfile: () -> Unit,
) {
    var selectedItem by remember() { mutableStateOf("myRoutines"    ) }
    NavigationBarItemDefaults.colors(selectedIconColor = Color.Blue, unselectedIconColor = Color.Red)

    NavigationBar(containerColor = DefaultBackground) {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "myRoutines") },
            label = { Text("My Routines") },
            onClick = {
                selectedItem = "myRoutines"
                onNavigateToMyRoutines()
            },
            selected = selectedItem == "myRoutines"
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Favorite, contentDescription = "Favourites") },
            label = { Text("Favourites") },
            onClick = {
                selectedItem = "fav"
                onNavigateToFavourites()
            },
            selected = selectedItem == "fav"
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Search, contentDescription = "Explore") },
            label = { Text("Explore") },
            onClick = {
                selectedItem = "exp"
                onNavigateToExplore()
            },
            selected = selectedItem == "exp"
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Person, contentDescription = "Me") },
            label = { Text("Me") },
            onClick = {
                selectedItem = "me"
                onNavigateToProfile()
            },
            selected = selectedItem == "me"
        )
    }
}