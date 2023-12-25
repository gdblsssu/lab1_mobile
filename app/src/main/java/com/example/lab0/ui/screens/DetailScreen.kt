package com.example.lab0.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.lab0.viewmodels.MainViewModel

@Composable
fun DetailScreen(navController: NavHostController, id: String?, viewModel: MainViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .weight(4f)){
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = rememberAsyncImagePainter(viewModel.cats),
                    contentDescription = "cat",
                    contentScale = ContentScale.Crop
                )
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .weight(2f)){
                Column {
                    Row(
                        Modifier.padding(top = 10.dp, bottom = 10.dp)
                    ) {
                        Text("Name : ${viewModel.catsList[id!!.toInt()].name}", style = MaterialTheme.typography.labelLarge,
                            fontSize = 20.sp)
                    }
                    Row {
                        Text("Description: The cat (Felis catus), commonly referred to as the " +
                                "domestic cat or house cat, is the only domesticated species in the " +
                                "family Felidae. Recent advances in archaeology and genetics have " +
                                "shown that the domestication of the cat occurred in the Near East " +
                                "around 7500 BC. It is commonly kept as a house pet and farm cat, " +
                                "but also ranges freely as a feral cat avoiding human contact.",
                            style = MaterialTheme.typography.labelLarge, fontSize = 20.sp)
                    }
                }


            }
        }


    }
}
