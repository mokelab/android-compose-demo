package com.mokelab.demo.composables

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mokelab.demo.composables.text.TextColor
import com.mokelab.demo.composables.text.TextDisplay
import com.mokelab.demo.composables.text.TextSize
import com.mokelab.demo.composables.text.TextTopScreen

fun NavGraphBuilder.composablesGraph(navController: NavController, route: String) {
    val back: () -> Unit = {
        navController.popBackStack()
    }
    val navigate: (route: String) -> Unit = {
        navController.navigate(it)
    }
    navigation(startDestination = "${route}/${routeTop}", route = route) {
        composable("${route}/${routeTop}") {
            TopScreen(routePrefix = route, back = back, navigate = navigate)
        }

        composable("${route}/${routeText}") {
            TextTopScreen(routePrefix = "${route}/${routeText}", back = back, navigate = navigate)
        }

        composable("${route}/${routeText}/${routeDisplay}") {
            TextDisplay(back = back)
        }
        composable("${route}/${routeText}/${routeColor}") {
            TextColor(back = back)
        }
        composable("${route}/${routeText}/${routeSize}") {
            TextSize(back = back)
        }
    }
}

const val routeTop = "top"
const val routeText = "text"
const val routeDisplay = "display"
const val routeColor = "color"
const val routeSize = "size"