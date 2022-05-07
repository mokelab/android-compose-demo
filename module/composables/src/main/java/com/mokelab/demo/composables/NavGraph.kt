package com.mokelab.demo.composables

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mokelab.demo.composables.button.buttonGraph
import com.mokelab.demo.composables.image.imageGraph
import com.mokelab.demo.composables.text.textGraph

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

        textGraph("${route}/${routeText}", back, navigate)
        imageGraph("${route}/${routeImage}", back, navigate)
        buttonGraph("${route}/${routeButton}", back, navigate)
    }
}

const val routeTop = "top"
const val routeText = "text"
const val routeImage = "image"
const val routeDisplay = "display"
const val routeColor = "color"
const val routeSize = "size"
const val routeResource = "resource"
const val routeCenterCrop = "centerCrop"
const val routeButton = "button"
const val routeContained = "contained"
const val routeOutlined = "outlined"