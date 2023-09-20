package com.example.lab0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab0.ui.theme.Lab0Theme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab0Theme {

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val username = remember{mutableStateOf("")}
    val pass = remember{mutableStateOf("")}
    val email = remember{mutableStateOf("")}

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ){
        Image(
            painter = painterResource(
            id = R.drawable.lefttop),
            contentDescription = "left top ellipse")
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterEnd
    ){
        Image(
            painter = painterResource(id = R.drawable.rigthcenter),
            contentDescription = "right center ellipse")
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ){
        Image(
            painter = painterResource(
            id = R.drawable.rightbot),
            contentDescription = "right bot ellipse")
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,

    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,) {
            Row(
                modifier = Modifier.padding(bottom = 90.dp)
            ) {
                Column {
                    Text("study ", fontSize = 50.sp, fontWeight = FontWeight.Black)
                }
                Column {
                    Text("IN", fontSize = 50.sp)
                }

            }
            Row(
                modifier = Modifier.padding(bottom = 15.dp)
            ) {
                OutlinedTextField(
                    value = username.value,
                    onValueChange = { username.value = it },
                    placeholder = { Text("Create Username") })
            }
            Row(
                modifier = Modifier.padding(bottom = 15.dp)
            ) {
                OutlinedTextField(
                    value = pass.value,
                    onValueChange = { pass.value = it },
                    placeholder = { Text("Create Password") })
            }
            Row(
                modifier = Modifier.padding(bottom = 15.dp)
            ) {
                OutlinedTextField(
                    value = email.value,
                    onValueChange = { email.value = it },
                    placeholder = { Text("Email ID") })
            }
            Row(
                modifier = Modifier.padding(top = 10.dp)
            ){
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    modifier = Modifier.width(130.dp)
                ) {
                    Text(text = "Join Us")
                }
            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab0Theme {
        Greeting(Modifier.fillMaxSize())
    }
}