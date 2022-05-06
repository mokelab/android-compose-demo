package com.mokelab.demo.compose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = routeTop) {
        composable(routeTop) {
            TopScreen()
        }
    }
}

const val routeTop = "top"