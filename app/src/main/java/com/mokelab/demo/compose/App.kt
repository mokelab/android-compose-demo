package com.mokelab.demo.compose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mokelab.demo.composables.composablesGraph

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = routeTop) {
        composable(routeTop) {
            TopScreen { route ->
                navController.navigate(route)
            }
        }
        composablesGraph(navController, routeComposables)
    }
}

const val routeTop = "top"
const val routeComposables = "composables"