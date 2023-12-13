package com.example.lab0.ui.screens

import MainViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.lab0.ui.theme.NavRoutes
import coil.compose.rememberAsyncImagePainter
import com.example.lab0.data.Cat
import androidx.compose.foundation.Image as Image
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(navController: NavHostController, viewModel: MainViewModel = hiltViewModel()) {
    val text = remember { mutableStateOf("")}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current
//вызываем запрос при старте экрана
        LaunchedEffect(context) {
            viewModel.requestCatList();
        }
        Column {
            OutlinedTextField(
                value = text.value,
                onValueChange = {
                    viewModel.loading = true
                    text.value = it
                    if (text.value == "") {
                        viewModel.requestCatList()
                    } else {
                        viewModel.requestCatListByName(text.value)
                    }
                }
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val cats by viewModel.cats.collectAsState(
                initial = emptyList()
            )
            if (viewModel.loading) {
                CircularProgressIndicator()
//если есть сообщение об ошибке, показываем его
            } else if (viewModel.errorMessage !== "") {
                Text(
                    modifier = Modifier.padding(all = 8.dp),
                    textAlign = TextAlign.Center,
                    text = viewModel.errorMessage,
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.Red
                )
            }
//рендерим список
            else CatsList(cats = ArrayList(cats), navController)
        }
    }

}
@Composable
fun CatsList(cats: ArrayList<Cat>, navController: NavHostController) {
    LazyColumn {
        items(cats.size) { index ->
            Card(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate(NavRoutes.Detail.route + "/$index")
                    }
            ) {

                Row(
                    modifier = Modifier.padding(all = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        modifier = Modifier.size(size = 100.dp),
                        painter = rememberAsyncImagePainter(cats[index].url),
                        contentDescription = "cat",
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        modifier = Modifier.padding(start = 30.dp),
                        text = cats[index].name,
                        fontSize = 20.sp
                    )
                }


            }
        }
    }
}
