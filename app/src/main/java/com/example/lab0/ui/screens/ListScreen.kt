package com.example.lab0.ui.screens

import MainViewModel
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.lab0.ui.theme.NavRoutes
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.lab0.data.Cat
import java.io.InputStream
import androidx.compose.foundation.Image as Image

@Composable
fun ListScreen(navController: NavHostController, viewModel: MainViewModel) {
    val context = LocalContext.current
    LaunchedEffect(context) {
        var json: String = ""
        val inputStream: InputStream = context.assets.open("data.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)

        inputStream.read(buffer)
        inputStream.close()

        json = String(buffer, charset("UTF-8"))
        viewModel.parseCatsList(json)
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CatsList(cats = viewModel.catsList, navController)
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
