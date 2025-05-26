package com.lduque.parcial2.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.lduque.parcial2.models.Product
import com.lduque.parcial2.models.products

class ProductScreenVM: ViewModel() {

    var product by mutableStateOf<Product?>(null)
        private set

    fun loadProduct(productID: Int){
        product = products.find{it.id == productID}
    }
}