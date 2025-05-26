package com.lduque.parcial2.models

data class Product(
    val id: Int,
    val name: String,
    val category: String,
    val price: Double,
    val image: String,
    var buy: Boolean
)

