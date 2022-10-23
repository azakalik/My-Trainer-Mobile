package com.example.mytrainermobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTrainerMobileTheme {
                // A surface container using the 'background' color from the theme
                DefaultPreview()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.blackMainTheme)), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally ) {
            Text(text = "My Trainer",color = Color.Magenta, fontSize = 60.sp)
            Text(text = stringResource(id = R.string.introScreenMessage), color = Color.White, fontSize = 30.sp)
            Button(onClick = { /*TODO enviar a pagina correspondiente*/ }, shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta)
            , modifier = Modifier.fillMaxWidth(0.5F)) {
                Text(text = stringResource(id = R.string.singInButton), fontSize = 30.sp)
            }
            Button(onClick = { /*TODO enviar a pagina correspondiente*/ }, shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta)
                , modifier = Modifier.fillMaxWidth(0.5F)) {
                Text(text = stringResource(id = R.string.signUpButton),color = Color.White, fontSize = 30.sp)
            }
        }
}