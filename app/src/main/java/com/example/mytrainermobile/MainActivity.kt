package com.example.mytrainermobile

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.activity.ComponentActivity
import androidx.compose.foundation.*

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.mytrainermobile.classes.Routine
import com.example.mytrainermobile.screens.BottomBar
import com.example.mytrainermobile.screens.TitleWorkout
import com.example.mytrainermobile.screens.TopBar
import com.example.mytrainermobile.screens.WorkoutView
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme
import kotlin.math.round

//import androidx.fragment.app.FragmentManager
//import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme
//import com.example.mytrainermobile.ui.theme.Purple500
//import com.google.android.material.datepicker.MaterialDatePicker
//import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.blackMainTheme)),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "My Trainer", color = Color.Magenta, fontSize = 60.sp)
        Text(
            text = stringResource(id = R.string.introScreenMessage),
            color = Color.White,
            fontSize = 30.sp
        )
        Button(
            onClick = { /*TODO enviar a pagina correspondiente*/ },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta),
            modifier = Modifier.fillMaxWidth(0.5F)
        ) {
            Text(text = stringResource(id = R.string.signInText), fontSize = 30.sp)
        }
        Button(
            onClick = { /*TODO enviar a pagina correspondiente*/ },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta),
            modifier = Modifier.fillMaxWidth(0.5F)
        ) {
            Text(
                text = stringResource(id = R.string.signUpText),
                color = Color.White,
                fontSize = 30.sp
            )
        }
    }
}

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
                    Text(
                        "TitleExercise",
                        style = TextStyle(Color.Magenta),
                        fontSize = 16.sp
                    )// replace for Api.fetch(title)
                    Spacer(modifier = Modifier.padding(75.dp, 10.dp))
                    Text(
                        "time/cycle",
                        style = TextStyle(Color.Gray),
                        fontSize = 8.sp
                    ) // replace for Api.fetch(time/cycle). See whats better and possible
                }
                Row {
                    Text(
                        "Exercise description",
                        style = TextStyle(Color.White),
                        fontSize = 10.sp
                    )// replace for Api.fetch(desc)
                    Spacer(modifier = Modifier.padding(75.dp, 5.dp))
                    Text("Difficulty", style = TextStyle(Color.White), fontSize = 8.sp)
                }
            }
        }
    }
}


@Composable
fun TitleForSection() {
    Text(
        text = "My Trainer",
        color = Color.Magenta,
        fontSize = 38.sp,
        modifier = Modifier.padding(start = 60.dp)
    )
}

@Composable
fun TitleBox(title: String, startPadding: Dp) {
    Box(
        modifier = Modifier
            .offset(x = (-5).dp)
            .border(
                width = 2.dp,
                color = Color.Magenta,
                shape = RoundedCornerShape(0.dp, 15.dp, 15.dp, 0.dp)
            )
            .fillMaxHeight(0.15f)
            .fillMaxWidth(0.45f)
    ) {
        Text(
            text = title,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(
                start = startPadding,
                top = 5.dp,
                bottom = 5.dp,
                end = 2.dp
            )
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FavouritesView() {

    val list = listOf<Routine>(
        Routine(1, "r1", "Chest"),
        Routine(2, "r2", "Back"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs"),
        Routine(3, "r3", "Legs")
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.blackMainTheme))
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f), verticalArrangement = Arrangement.SpaceEvenly
            ) {
                TitleForSection()
                TitleBox(title = "Favourites", 80.dp)
            }
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalArrangement = Arrangement.Center,
                columns = GridCells.Fixed(2),
                content = {
                    items(list.size) { idx ->
                        RoutineBox(
                            routineName = list[idx].name,
                            routineType = list[idx].type
                        )
                    }
                })
        }
    }
}

@Composable
fun RoutineBox(routineName: String, routineType: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable {  /*TODO*/ },
        elevation = 10.dp,
        shape = RoundedCornerShape(15.dp)
    ) {
        Box(modifier = Modifier.height(90.dp)) {
            Image(
                painter = painterResource(id = R.drawable.arms),
                contentDescription = "image",
                contentScale = ContentScale.FillBounds
            )

        }
    }
}

//--------------------------------------------------------------------------------

@Composable
fun ExerciseBox() {
    Card(
        modifier = Modifier.fillMaxWidth(1f).height(75.dp),
        shape = RoundedCornerShape(15.dp)

    ) {
        Row(
            modifier = Modifier
                .background(Color(0xFF1E1E1E))
                .padding(8.dp)
        ) {
            //Image(painter = painterResource(id = R.drawable.))
            Column {
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        "TitleExercise",
                        style = TextStyle(Color.Magenta),
                        fontSize = 20.sp
                    )// replace for Api.fetch(title)
                    //Spacer(modifier = Modifier.padding(65.dp, 10.dp))
                    Text(
                        "time/cycle",
                        style = TextStyle(Color.Gray),
                        fontSize = 12.sp
                    ) // replace for Api.fetch(time/cycle). See whats better and possible
                }
                //Spacer(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp))
                Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
                    Text(
                        "Exercise description",
                        style = TextStyle(Color.White),
                        fontSize = 14.sp
                    )// replace for Api.fetch(desc)
                    //Spacer(modifier = Modifier.padding(65.dp, 5.dp))
                    Text("Difficulty", style = TextStyle(Color.White), fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
fun StartButton() {
    Button(
        onClick = { },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta),
        modifier = Modifier
            .fillMaxWidth(0.5F)
            .padding(0.dp, 15.dp, 0.dp, 25.dp),
    ) {
        Text("Start Workout")
    }
}

@Composable
fun WorkoutBar() {
    Box(
        Modifier
            .background(Color(0xFF1E1E1E))
            .fillMaxWidth(1f)
    ) {
        Column() {
            Row(Modifier.fillMaxWidth(1f),
                horizontalArrangement = Arrangement.SpaceBetween,) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier.size(50.dp),
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "back arrow"
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier.size(50.dp),
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Favorite"

                    )
                    Text("Favourite Me!")
                }
            }
            Column(
                Modifier.fillMaxWidth(1f),
                horizontalAlignment = Alignment.End
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier.size(50.dp),
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Star"

                    )
                    Text("Rate Me!")
                }
            }
        }
    }
}

@Composable
fun StartBar() {
    Box(
        Modifier
            .background(Color(0xFF1E1E1E))
            .fillMaxWidth(1f),
        contentAlignment = Alignment.Center
    ) {
        StartButton()
    }
}

@Preview
@Composable
fun StartWorkout() {
    val list = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5 ,6 ,7 ,8)
    Scaffold(modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.DarkGray,
        topBar = { WorkoutBar() },
        bottomBar = { StartBar() }) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize(1f)
                .background(Color.DarkGray)
        ) {
            Spacer(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp))
            DescriptorBox()
            Box(
                modifier = Modifier
                    .height(180.dp)
                    .width(180.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.arms),
                    contentDescription = "image",
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    contentScale = ContentScale.FillBounds
                )
            }
            LazyColumn(
                modifier = Modifier
                    .padding(), contentPadding = PaddingValues(20.dp)
            ) {
                items(items = list, itemContent = { item ->
                    Box(modifier = Modifier.padding(10.dp)) {
                        ExerciseBox()
                    }//reemplazar item por datos de la lista a enviar a routineBox2
                })
            }

        }
    }
}

@Composable
fun DescriptorBox() {
    Box(modifier = Modifier.fillMaxWidth()
        .background(Color.Magenta, RoundedCornerShape(0.dp, 15.dp, 15.dp, 0.dp))
        .offset(x = (-5).dp)
        .border(2.dp, Color.Black, shape = RoundedCornerShape(0.dp, 15.dp, 15.dp, 0.dp))
        .height(95.dp)
        ) {
        Column() {
            Row(Modifier.offset(x=10.dp)){
                Text("Routine Title", fontSize = 24.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 10.dp))
            Row(Modifier.offset(x=10.dp)){
                Text("38'", color = Color.White) // tiempo de rutina???
                Text("Intermediate", color = Color.White) // dificultad
            }
            Spacer(modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 10.dp))
            Row(Modifier.offset(x=10.dp)){
                Text("Rating", color = Color.White) // rating
                Text("username", color = Color.White) // username????
            }
        }
        Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth()){
            IconButton(onClick = { /*TODO*/ }) {
                Column() {
                    Icon(
                        modifier = Modifier.size(50.dp),
                        imageVector = Icons.Filled.Share,
                        contentDescription = "Share",
                        tint = Color.White
                    )

                    Text("Share")
                }
            }
        }
    }
}

//---------------------------------------------------------------------------------------------------