package com.leksilab.descuentosapp.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeView() {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Porcentage Descuentos") },
            backgroundColor = MaterialTheme.colors.primary
        )
    }) {
        HomeViewContent(it)
    }

}

@Composable
fun HomeViewContent(paddingValues: PaddingValues) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues = paddingValues)
        .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "HOLIS PERRIS")
    }
}