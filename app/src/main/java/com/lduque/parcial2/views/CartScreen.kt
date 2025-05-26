package com.lduque.parcial2.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.lduque.parcial2.components.navBarTopBar
import com.lduque.parcial2.models.shoppingCart

@Composable
fun CartScreen(navController: NavController) {
    navBarTopBar(navController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
        ) {
            Text(text = "Carrito de compras", color = Color.Black)

            Spacer(modifier = Modifier.height(16.dp))

            if (shoppingCart.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("El carrito está vacío", color = Color.Gray)
                }
            } else {
                LazyColumn {
                    items(shoppingCart) { product ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            AsyncImage(
                                model = product.image,
                                contentDescription = product.name,
                                modifier = Modifier.size(64.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(text = product.name, color = Color.Black)
                                Text(text = "$${product.price}", color = Color.DarkGray)
                            }
                        }
                    }
                }
            }
        }
    }
}
