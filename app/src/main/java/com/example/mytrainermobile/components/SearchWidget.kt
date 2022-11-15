package com.example.mytrainermobile.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mytrainermobile.R
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.viewModels.ExploreViewModel

@Composable
fun SearchBar(navController: NavHostController, viewModel: ExploreViewModel) {
    var query by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        modifier = Modifier
            .padding(1.dp)
            .fillMaxWidth(0.8f),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = DefaultBackground,
            focusedLabelColor = Color.LightGray,
            trailingIconColor = Color.White,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
        ),
        shape = CircleShape,
        trailingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "searchBar") },
        value = query,
        onValueChange = {
            query = it
        },
        label = {
            Text(
                text = stringResource(R.string.search),
                modifier = Modifier.padding(horizontal = 5.dp),
                textAlign = TextAlign.Center)
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = { navController.navigate("search/${query.text}");/*viewModel.getRoutinesBySearch(query = query.text)*/ }
        )
    )
}