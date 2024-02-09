package com.leksilab.descuentosapp.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.leksilab.descuentosapp.components.*
import com.leksilab.descuentosapp.viewmodels.CalcularViewModel3

@Composable
fun HomeView3(viewModel3: CalcularViewModel3) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Calcular Descuentos") },
            backgroundColor = MaterialTheme.colors.primary
        )
    }) {
        HomeViewContent3(it, viewModel3)
    }

}

@Composable
fun HomeViewContent3(paddingValues: PaddingValues, viewModel3: CalcularViewModel3) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues = paddingValues)
        .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val state = viewModel3.state
        TwoCards(title1 = "Total:", number1 = state.totalDescuento, title2 = "Descuento:", number2 = state.precioDescuento)
        MainTextField(value = state.precio, onValueChange = { viewModel3.onValue(it, "precio") }, label = "Precio")
        SpaceH()
        MainTextField(value = state.descuento, onValueChange = { viewModel3.onValue(it, "descuento") }, label = "Descuento")
        SpaceH(10.dp)
        MainButton(text = "Generar Descuento") {
            viewModel3.calcular()
        }
        SpaceH()
        MainButton(text = "Limpiar", color = Color.Red) {
            viewModel3.limpiar()
        }

        if (state.showAlert) {
            Alert(
                title = "Alerta",
                message = "Los campos no puden ir vacios",
                confirmText = "Aceptar",
                onConfirmClick = { viewModel3.cancelAlert() }) { }
        }

    }
}

