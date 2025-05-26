package com.lduque.parcial2

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lduque.parcial2.views.CartScreen
import com.lduque.parcial2.views.HomeScreen
import com.lduque.parcial2.views.ProductScreen

@Composable
fun NavigationStack(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "HomeScreen"){
        composable("HomeScreen"){
            HomeScreen(navController = navController)
        }
        composable("CartScreen"){
            CartScreen(navController = navController)
        }
        composable("PetScreen/{petId}"){ backStackEntry ->
            val petId = backStackEntry.arguments?.getString("petId")?.toIntOrNull()
            petId?.let{
                ProductScreen(navController = navController, productId = it)
            }
        }
    }
}