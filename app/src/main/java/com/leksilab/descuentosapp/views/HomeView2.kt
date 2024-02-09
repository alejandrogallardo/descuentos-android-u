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
import com.leksilab.descuentosapp.viewmodels.CalcularViewModel2

@Composable
fun HomeView2(viewModel2: CalcularViewModel2) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Calcular Descuentos") },
            backgroundColor = MaterialTheme.colors.primary
        )
    }) {
        HomeViewContent2(it, viewModel2)
    }

}

@Composable
fun HomeViewContent2(paddingValues: PaddingValues, viewModel2: CalcularViewModel2) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues = paddingValues)
        .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TwoCards(title1 = "Total:", number1 = viewModel2.totalDescuento, title2 = "Descuento:", number2 = viewModel2.precioDescuento)
        MainTextField(value = viewModel2.precio, onValueChange = { viewModel2.onValue(it, "precio") }, label = "Precio")
        SpaceH()
        MainTextField(value = viewModel2.descuento, onValueChange = { viewModel2.onValue(it, "descuento") }, label = "Descuento")
        SpaceH(10.dp)
        MainButton(text = "Generar Descuento") {
            viewModel2.calcular()
        }
        SpaceH()
        MainButton(text = "Limpiar", color = Color.Red) {
            viewModel2.limpiar()
        }

        if (viewModel2.showAlert) {
            Alert(
                title = "Alerta",
                message = "Los campos no puden ir vacios",
                confirmText = "Aceptar",
                onConfirmClick = { viewModel2.cancelAlert() }) { }
        }

    }
}