package com.mokelab.demo.composables.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mokelab.demo.composables.*
import com.mokelab.demo.compose.list.ListItem
import com.mokelab.demo.compose.list.SimpleList

@Composable
fun ButtonTopScreen(
    routePrefix: String,
    back: () -> Unit,
    navigate: (route: String) -> Unit,
) {
    val items = listOf(
        ListItem(
            stringResource(id = R.string.composables_button_contained),
            "${routePrefix}/${routeContained}"
        ),
        ListItem(
            stringResource(id = R.string.composables_button_outlined),
            "${routePrefix}/${routeOutlined}"
        ),
        ListItem(
            stringResource(id = R.string.composables_button_text),
            "${routePrefix}/${routeText}"
        ),
    )
    SimpleList(
        title = stringResource(id = R.string.composables_button),
        listItems = items,
        back = back,
        navigate = navigate
    )
}

fun NavGraphBuilder.buttonGraph(
    route: String,
    back: () -> Unit,
    navigate: (route: String) -> Unit,
) {
    navigation(startDestination = "${route}/${routeTop}", route = route) {
        composable("${route}/${routeTop}") {
            ButtonTopScreen(
                routePrefix = route,
                back = back,
                navigate = navigate
            )
        }
        composable("${route}/${routeContained}") {
            ButtonContainedScreen(back = back)
        }
        composable("${route}/${routeOutlined}") {
            ButtonOutlinedScreen(back = back)
        }
        composable("${route}/${routeText}") {
            ButtonTextScreen(back = back)
        }
    }
}