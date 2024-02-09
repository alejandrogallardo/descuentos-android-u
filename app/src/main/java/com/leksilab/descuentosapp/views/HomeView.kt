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
import com.leksilab.descuentosapp.viewmodels.CalcularViewModel1

@Composable
fun HomeView(viewModel1: CalcularViewModel1) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Calcular Descuentos") },
            backgroundColor = MaterialTheme.colors.primary
        )
    }) {
        HomeViewContent(it, viewModel1)
    }

}

@Composable
fun HomeViewContent(paddingValues: PaddingValues, viewModel1: CalcularViewModel1) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues = paddingValues)
        .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var precio by remember { mutableStateOf("") }
        var descuento by remember { mutableStateOf("") }
        var precioDescuento by remember { mutableStateOf(0.0) }
        var totalDescuento by remember { mutableStateOf(0.0) }
        var showAlert by remember { mutableStateOf(false) }
        TwoCards(title1 = "Total:", number1 = totalDescuento, title2 = "Descuento:", number2 = precioDescuento)
        MainTextField(value = precio, onValueChange = { precio = it }, label = "Precio")
        SpaceH()
        MainTextField(value = descuento, onValueChange = { descuento = it }, label = "Descuento")
        SpaceH(10.dp)
        MainButton(text = "Generar Descuento") {
            val result = viewModel1.calcular(precio, descuento)
            showAlert = result.second.second
            if (!showAlert) {
                precioDescuento = result.first
                totalDescuento = result.second.first
            }
        }
        SpaceH()
        MainButton(text = "Limpiar", color = Color.Red) {
            precio = ""
            descuento = ""
            precioDescuento = 0.0
            totalDescuento = 0.0
        }

        if (showAlert) {
            Alert(
                title = "Alerta",
                message = "Los campos no puden ir vacios",
                confirmText = "Aceptar",
                onConfirmClick = { showAlert = false }) { }
        }

    }
}