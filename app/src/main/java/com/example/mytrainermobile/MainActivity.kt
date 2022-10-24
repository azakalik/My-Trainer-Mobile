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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTrainerMobileTheme {
                // A surface container using the 'background' color from the theme
                ArriveScreen()
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
fun ArriveScreen() {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.blackMainTheme)), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally ) {
            Text(text = "My Trainer",color = Color.Magenta, fontSize = 60.sp)
            Text(text = stringResource(id = R.string.introScreenMessage), color = Color.White, fontSize = 30.sp)
            Button(onClick = { /*TODO enviar a pagina correspondiente*/ }, shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta)
            , modifier = Modifier.fillMaxWidth(0.5F)) {
                Text(text = stringResource(id = R.string.signInButton), fontSize = 30.sp)
            }
            Button(onClick = { /*TODO enviar a pagina correspondiente*/ }, shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta)
                , modifier = Modifier.fillMaxWidth(0.5F)) {
                Text(text = stringResource(id = R.string.signUpButton),color = Color.White, fontSize = 30.sp)
            }
        }
}

@Preview
@Composable
fun ShowSignupScreen(){
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        Column() {
            SignupText()
            ShowForm()
        }
    }
}

@Composable
fun SignupText(){
    Text(text = "Sign up",
        style = Typography().h3.copy(fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(vertical = 40.dp)
        )
}

@Composable
fun ShowForm() {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var surname by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var email2 by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var password2 by remember { mutableStateOf(TextFieldValue("")) }
    Column() {
        TextField(
            value = name,
            placeholder = {Text("Insert name")},
            onValueChange = { newName ->
                name = newName
            },
            modifier = Modifier.padding(vertical = 5.dp)
        )
        TextField(
            value = surname,
            placeholder = {Text("Insert surname")},
            onValueChange = { newSurname ->
                surname = newSurname
            },
            modifier = Modifier.padding(vertical = 5.dp)
        )
        TextField(
            value = email,
            placeholder = {Text("Insert email")},
            onValueChange = { newEmail ->
                email = newEmail
            },
            modifier = Modifier.padding(vertical = 5.dp)
        )
        TextField(
            value = email2,
            placeholder = {Text("Reinsert email")},
            onValueChange = { newEmail2 ->
                email2 = newEmail2
            },
            modifier = Modifier.padding(vertical = 5.dp)
        )
        TextField(
            value = password,
            placeholder = {Text("Insert password")},
            onValueChange = { newPassword ->
                password = newPassword
            },
            modifier = Modifier.padding(vertical = 5.dp)
        )
        TextField(
            value = password2,
            placeholder = {Text("Reinsert password")},
            onValueChange = { newPassword2 ->
                password2 = newPassword2
            },
            modifier = Modifier.padding(vertical = 5.dp)
        )
        //aca iria el datepicker
    }

}
