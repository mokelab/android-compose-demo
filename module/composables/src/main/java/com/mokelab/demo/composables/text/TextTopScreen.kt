package com.mokelab.demo.composables.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mokelab.demo.composables.*
import com.mokelab.demo.compose.list.ListItem
import com.mokelab.demo.compose.list.SimpleList

@Composable
fun TextTopScreen(
    routePrefix: String,
    back: () -> Unit,
    navigate: (route: String) -> Unit,
) {
    val items = listOf(
        ListItem(
            stringResource(id = R.string.composables_text_display),
            "${routePrefix}/${routeDisplay}"
        ),
        ListItem(
            stringResource(id = R.string.composables_text_color),
            "${routePrefix}/${routeColor}"
        ),
        ListItem(
            stringResource(id = R.string.composables_text_size),
            "${routePrefix}/${routeSize}"
        )
    )
    SimpleList(
        title = stringResource(id = R.string.composables_text),
        listItems = items,
        back = back,
        navigate = navigate
    )
}

fun NavGraphBuilder.textGraph(
    route: String,
    back: () -> Unit,
    navigate: (route: String) -> Unit,
) {
    navigation(startDestination = "${route}/$routeTop", route = route) {
        composable("${route}/$routeTop") {
            TextTopScreen(
                routePrefix = route,
                back = back,
                navigate = navigate
            )
        }
        composable("${route}/${routeDisplay}") {
            TextDisplay(back = back)
        }
        composable("${route}/${routeColor}") {
            TextColor(back = back)
        }
        composable("${route}/${routeSize}") {
            TextSize(back = back)
        }
    }
}