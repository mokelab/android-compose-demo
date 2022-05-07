package com.mokelab.demo.composables.image

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mokelab.demo.composables.R
import com.mokelab.demo.composables.routeCenterCrop
import com.mokelab.demo.composables.routeResource
import com.mokelab.demo.composables.routeTop
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