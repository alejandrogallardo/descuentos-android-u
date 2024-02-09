package com.leksilab.descuentosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.leksilab.descuentosapp.ui.theme.DescuentosAppTheme
import com.leksilab.descuentosapp.viewmodels.CalcularViewModel1
import com.leksilab.descuentosapp.viewmodels.CalcularViewModel2
import com.leksilab.descuentosapp.views.HomeView
import com.leksilab.descuentosapp.views.HomeView2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val viewModel: CalcularViewModel1 by viewModels()
        val viewModel2: CalcularViewModel2 by viewModels()
        setContent {
            DescuentosAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //HomeView(viewModel)
                    HomeView2(viewModel2)
                }
            }
        }
    }
}