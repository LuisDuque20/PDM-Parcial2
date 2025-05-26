package com.lduque.parcial2.models

import androidx.compose.runtime.mutableStateListOf

val products = listOf(
    // Tecnología
    Product(
        id = 1,
        name = "Auriculares Bluetooth",
        category = "tecnologia",
        price = 59.99,
        image = "https://www.steren.com.sv/media/catalog/product/cache/295a12aacdcb0329a521cbf9876b29e7/image/21867108a/audifonos-bluetooth-con-cancelacion-de-ruido-negros.jpg",
        buy = false
    ),
    Product(
        id = 2,
        name = "PlayStation 5",
        category = "tecnologia",
        price = 400.00,
        image = "https://walmartcr.vtexassets.com/arquivos/ids/782619/74602_01.jpg?v=638678426586800000",
        buy = false
    ),
    // Cuidado personal
    Product(
        id = 3,
        name = "Cepillo de dientes eléctrico",
        category = "cuidado personal",
        price = 35.50,
        image = "https://walmartsv.vtexassets.com/arquivos/ids/709237/89025_01.jpg?v=638784460373400000",
        buy = false
    ),
    Product(
        id = 4,
        name = "Crema hidratante facial",
        category = "cuidado personal",
        price = 24.99,
        image = "https://walmartsv.vtexassets.com/arquivos/ids/492644-800-450?v=638582242560070000&width=800&height=450&aspect=true",
        buy = false
    ),

    // Comida
    Product(
        id = 5,
        name = "Caja de galletas artesanales",
        category = "comida",
        price = 12.75,
        image = "https://tofuu.getjusto.com/orioneat-local/resized2/J7vnAWt5D4QNR26wv-1600-x.webp",
        buy = false
    ),
    Product(
        id = 6,
        name = "Pack de snacks saludables",
        category = "comida",
        price = 17.20,
        image = "https://i0.wp.com/trohpiohsnacks.com/wp-content/uploads/2024/01/Empaques-Chips-Trophi-Oh-700.png?resize=700%2C664&ssl=1",
        buy = false
    )
)

val shoppingCart = mutableStateListOf<Product>()