package com.lduque.parcial2.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.lduque.parcial2.components.navBarTopBar
import com.lduque.parcial2.models.products
import com.lduque.parcial2.viewModel.ProductScreenVM


import androidx.compose.material3.Button
import androidx.compose.material3.Text
import com.lduque.parcial2.models.shoppingCart

@Composable
fun ProductScreen(navController: NavController, productId: Int) {
    val modifier = Modifier
    val productViewModel: ProductScreenVM = viewModel()

    LaunchedEffect(productId) {
        productViewModel.loadProduct(productId)
    }

    val product = productViewModel.product

    navBarTopBar(navController) {
        if (product != null) {
            Column(
                modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(20.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                AsyncImage(model = product.image, contentDescription = " ${product.name} ")
                Text(text = "${product.name} - ${product.price}", color = Color.Black)

                // Botón de compra
                Button(
                    onClick = {
                        if (!product.buy) {
                            product.buy = true
                            if (!shoppingCart.contains(product)) {
                                shoppingCart.add(product)
                            }
                        }
                    },
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text(text = if (product.buy) "Agregado al carrito" else "Comprar")
                }
            }
        }
    }
}
