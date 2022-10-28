package com.example.mytrainermobile

import android.app.DatePickerDialog
import android.graphics.Picture
import android.os.Bundle
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme
import com.example.mytrainermobile.ui.theme.Purple500
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class ExerciseViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTrainerMobileTheme {
                ExerciseView()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ExerciseView() {
    Column(
    modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.blackMainTheme)),
    verticalArrangement = Arrangement.SpaceBetween,
    horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
        modifier = Modifier
            .fillMaxSize()
            .weight(1F)
            .background(color = Color.Black)
        ) {
            Text(text = "Current Exercise", color = Color.Magenta, fontSize = 24.sp)
        }

        Box(
        modifier = Modifier
            .fillMaxSize()
            .weight(10F)
            .background(color = Color.White)
        ) {
            Text(text = "Picture", color = Color.Black, fontSize = 60.sp)
        }

        Box(
        modifier = Modifier
            .fillMaxSize()
            .weight(1F)
            .background(color = Color.Black)
        ) {

            Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
            ) {

                Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta)
                ) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "Previous Exercise",
                        modifier = Modifier.size(33.dp)
                    )
                }

                Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta)
                ) {
                    Icon(
                        Icons.Outlined.PlayArrow,
                        contentDescription = "Previous Exercise",
                        modifier = Modifier.size(33.dp)
                    )
                }

                Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta)
                ) {
                    Icon(
                        Icons.Filled.ArrowForward,
                        contentDescription = "Previous Exercise",
                        modifier = Modifier.size(33.dp)
                    )
                }

            }

        }

    }
}

