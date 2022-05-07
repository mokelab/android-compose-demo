package com.mokelab.demo.composables.image

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mokelab.demo.composables.*
import com.mokelab.demo.composables.text.TextColor
import com.mokelab.demo.composables.text.TextDisplay
import com.mokelab.demo.composables.text.TextSize
import com.mokelab.demo.composables.text.TextTopScreen
import com.mokelab.demo.compose.list.ListItem
import com.mokelab.demo.compose.list.SimpleList

@Composable
fun ImageTopScreen(
    routePrefix: String,
    back: () -> Unit,
    navigate: (route: String) -> Unit,
) {
    val items = listOf(
        ListItem(
            stringResource(id = R.string.composables_image_resource),
            "${routePrefix}/${routeResource}"
        ),
        ListItem(
            stringResource(id = R.string.composables_image_center_crop),
            "${routePrefix}/${routeCenterCrop}"
        ),
    )
    SimpleList(
        title = stringResource(id = R.string.composables_image),
        listItems = items,
        back = back,
        navigate = navigate
    )
}

fun NavGraphBuilder.imageGraph(
    route: String,
    back: () -> Unit,
    navigate: (route: String) -> Unit,
) {
    navigation(startDestination = "${route}/$routeTop", route = route) {
        composable("${route}/$routeTop") {
            ImageTopScreen(
                routePrefix = route,
                back = back,
                navigate = navigate
            )
        }
        composable("${route}/${routeResource}") {
            ImageResourceScreen(back = back)
        }
        composable("${route}/${routeCenterCrop}") {
            ImageCenterCropScreen(back = back)
        }
    }
}