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

@Composable
fun HomeView() {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Calcular Descuentos") },
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
            if (precio != "" && descuento != "") {
                precioDescuento = calcularPrecio(precio.toDouble(), descuento.toDouble())
                totalDescuento = calcularDescuento(precio.toDouble(), descuento.toDouble())
            } else {
                showAlert = true
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

fun calcularPrecio(precio: Double, descuento: Double): Double {
    val res = precio - calcularDescuento(precio, descuento)
    return kotlin.math.round(res * 100) / 100.0
}

fun calcularDescuento(precio: Double, descuento: Double): Double {
    val res = precio * (1 - descuento / 100)
    return kotlin.math.round(res * 100) / 100.0
}