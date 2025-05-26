package com.lduque.parcial2.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.lduque.parcial2.models.products

class HomeScreenVM: ViewModel(){
    private val _categories = listOf(
        "tecnologia",
        "cuidado personal",
        "comida"
    )

    var buscar by mutableStateOf("")
        private set

    var filteredProducts = mutableStateOf(products)
        private set

    fun actualizarBusqueda(nuevoTexto: String){
        buscar = nuevoTexto
        filterProducts()
    }

    private fun filterProducts(){
        filteredProducts.value = products.filter{ product ->
            val nameMatch = product.name.contains(buscar, ignoreCase = true)
            val tipoMatch = product.category.contains(buscar, ignoreCase = true)

            nameMatch || tipoMatch
        }
    }
}