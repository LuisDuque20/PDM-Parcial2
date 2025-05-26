package com.lduque.parcial2.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lduque.parcial2.components.navBarTopBar
import com.lduque.parcial2.viewModel.HomeScreenVM
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.TextField
import androidx.navigation.NavController
import com.lduque.parcial2.components.ProductCard

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel: HomeScreenVM = viewModel()
    val filteredProducts = viewModel.filteredProducts.value

    navBarTopBar(navController) {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(10.dp)
        ) {
            TextField(
                value = viewModel.buscar,
                onValueChange = { viewModel.actualizarBusqueda(it) },
                label = { Text("Busca una mascota", color = Color.Black) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Spacer(Modifier.height(10.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(10.dp)
            ) {
                items(filteredProducts) { product ->
                    ProductCard(product = product) {
                        navController.navigate("PetScreen/${product.id}")
                    }
                }
            }
        }
    }
}