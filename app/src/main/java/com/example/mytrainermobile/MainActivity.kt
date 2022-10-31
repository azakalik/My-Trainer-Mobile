package com.example.mytrainermobile

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.activity.ComponentActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytrainermobile.classes.Routine
import com.example.mytrainermobile.screens.WorkoutView
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTrainerMobileTheme {
                // A surface container using the 'background' color from the theme
                //ArriveScreen()
                WorkoutView()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

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
@Preview
@Composable
fun RoutineBox2() {
    Card(
            modifier = Modifier.fillMaxWidth(1f),
            shape = RoundedCornerShape(15.dp)

        ) {
        Row(
            modifier = Modifier
                .background(Color(0xFF1E1E1E))
                .padding(8.dp)
        ) {
            //Image()
            Column {
                Row {
                    Text("TitleExercise", style = TextStyle(Color.Magenta), fontSize = 16.sp )// replace for Api.fetch(title)
                    Spacer(modifier = Modifier.padding(75.dp,10.dp))
                    Text("time/cycle", style = TextStyle(Color.Gray), fontSize = 8.sp) // replace for Api.fetch(time/cycle). See whats better and possible
                }
                Row {
                    Text("Exercise description", style = TextStyle(Color.White), fontSize = 10.sp)// replace for Api.fetch(desc)
                    Spacer(modifier = Modifier.padding(75.dp, 5.dp))
                    Text("Difficulty", style = TextStyle(Color.White), fontSize = 8.sp)
                }
            }
        }
    }
}

@Composable
fun TitleForSection(){
    Text(text= "My Trainer",color = Color.Magenta, fontSize = 38.sp, modifier = Modifier.padding(start = 60.dp))
}

@Composable
fun TitleBox(title: String, startPadding: Dp){
    Box(modifier = Modifier
        .offset(x = (-5).dp)
        .border(
            width = 2.dp,
            color = Color.Magenta,
            shape = RoundedCornerShape(0.dp, 15.dp, 15.dp, 0.dp)
        )
        .fillMaxHeight(0.15f)
        .fillMaxWidth(0.45f)
    ){
        Text(text = title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp,modifier = Modifier.padding(start = startPadding,top = 5.dp, bottom = 5.dp, end = 2.dp))
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun FavouritesView(){

    val list  = listOf<Routine>(
        Routine(1,"r1","Chest"),Routine(2,"r2","Back"),
        Routine(3,"r3","Legs"),Routine(3,"r3","Legs"),Routine(3,"r3","Legs"),Routine(3,"r3","Legs"),Routine(3,"r3","Legs"),
        Routine(3,"r3","Legs"),Routine(3,"r3","Legs"),Routine(3,"r3","Legs"),Routine(3,"r3","Legs"),Routine(3,"r3","Legs"),
        Routine(3,"r3","Legs"),Routine(3,"r3","Legs"),
        Routine(3,"r3","Legs"),Routine(3,"r3","Legs"),Routine(3,"r3","Legs"),Routine(3,"r3","Legs")
    )
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.blackMainTheme)) ){
        Column(modifier = Modifier.fillMaxSize()) {
            Column( modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f), verticalArrangement = Arrangement.SpaceEvenly) {
                TitleForSection()
                TitleBox(title = "Favourites", 80.dp)
            }
            LazyVerticalGrid(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceAround,verticalArrangement = Arrangement.Center, columns = GridCells.Fixed(2) , content = {
                items(list.size) {
                        idx -> RoutineBox(routineName = list[idx].name, routineType = list[idx].type)
                }
            })
        }

    }
}

@Composable 
fun RoutineBox(routineName: String, routineType: String){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp)
        .clickable {  /*TODO*/ }, elevation = 10.dp, shape = RoundedCornerShape(15.dp)
    ) {
        Box(modifier = Modifier.height(90.dp)){
            Image(painter = painterResource(id = R.drawable.arms), contentDescription = "image", contentScale = ContentScale.FillBounds)

        }
    }
}
