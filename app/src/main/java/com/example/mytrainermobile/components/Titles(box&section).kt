package com.example.mytrainermobile.components


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytrainermobile.ui.theme.DefaultColor
import com.example.mytrainermobile.R


@Composable
fun TitleForSection(bigScreenMode : Boolean = false) {
    val size = if(bigScreenMode) 96.sp else 44.sp
    Text(
        text = stringResource(id = R.string.title),
        color = DefaultColor,
        fontSize = size,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun TitleBox(title: String, bigScreenMode: Boolean = false) {
    val size = if(bigScreenMode) 32.sp else 16.sp
    Box(
        modifier = Modifier
            .offset(x = (-5).dp)
            .border(
                width = 2.dp,
                color = DefaultColor,
                shape = RoundedCornerShape(0.dp, 15.dp, 15.dp, 0.dp)
            )
    ){
        Row {
            Text(
                text = title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = size,
                modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)
            )
        }
    }
}
