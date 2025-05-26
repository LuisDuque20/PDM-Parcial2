package com.lduque.parcial2.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.lduque.parcial2.models.Product

class CartScreenVM : ViewModel() {

    private val _shoppingCart = mutableStateListOf<Product>()
    val shoppingCart: List<Product> = _shoppingCart

    fun addToCart(product: Product) {
        if (!_shoppingCart.any { it.id == product.id }) {
            _shoppingCart.add(product.copy(buy = true))
        }
    }

    fun clearCart() {
        _shoppingCart.clear()
    }
}
