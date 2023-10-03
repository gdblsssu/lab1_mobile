package com.example.lab0.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.lab0.ui.theme.NavRoutes

@Composable
fun ListScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("ListScreen", style = MaterialTheme.typography.labelLarge)
        Button(onClick = {navController.navigate(NavRoutes.Detail.route+"/47")} ) {
            Text(text = "Go Detail")
        }
    }
}
