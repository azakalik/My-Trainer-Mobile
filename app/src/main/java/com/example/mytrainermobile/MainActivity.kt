package com.example.mytrainermobile


import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.ComponentActivity
import com.example.mytrainermobile.screens.ArriveScreen
import com.example.mytrainermobile.screens.MyRoutines
import com.example.mytrainermobile.screens.ViewWorkout
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTrainerMobileTheme {
                // A surface container using the 'background' color from the theme
                MyRoutines()
            }
        }
    }
}





