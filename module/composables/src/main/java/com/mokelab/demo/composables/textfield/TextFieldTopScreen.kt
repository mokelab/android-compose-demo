package com.mokelab.demo.composables.textfield

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mokelab.demo.composables.*
import com.mokelab.demo.compose.list.ListItem
import com.mokelab.demo.compose.list.SimpleList

@Composable
fun TextFieldTopScreen(
    routePrefix: String,
    back: () -> Unit,
    navigate: (route: String) -> Unit,
) {
    val items = listOf(
        ListItem(
            stringResource(id = R.string.composables_textfield_display),
            "${routePrefix}/${routeDisplay}"
        ),
        ListItem(
            stringResource(id = R.string.composables_textfield_label),
            "${routePrefix}/${routeLabel}"
        ),
        ListItem(
            stringResource(id = R.string.composables_textfield_placeholder),
            "${routePrefix}/${routePlaceholder}"
        ),
        ListItem(
            stringResource(id = R.string.composables_textfield_password),
            "${routePrefix}/${routePassword}"
        ),
        ListItem(
            stringResource(id = R.string.composables_textfield_outlined),
            "${routePrefix}/${routeOutlined}"
        ),
    )
    SimpleList(
        title = stringResource(id = R.string.composables_textfield),
        listItems = items,
        back = back,
        navigate = navigate
    )
}

fun NavGraphBuilder.textFieldGraph(
    route: String,
    back: () -> Unit,
    navigate: (route: String) -> Unit,
) {
    navigation(startDestination = "${route}/$routeTop", route = route) {
        composable("${route}/$routeTop") {
            TextFieldTopScreen(
                routePrefix = route,
                back = back,
                navigate = navigate
            )
        }
        composable("${route}/$routeDisplay") {
            TextFieldDisplayScreen(back = back)
        }
        composable("${route}/$routeLabel") {
            TextFieldLabelScreen(back = back)
        }
        composable("${route}/$routePlaceholder") {
            TextFieldPlaceholderScreen(back = back)
        }
        composable("${route}/$routePassword") {
            TextFieldPasswordScreen(back = back)
        }
        composable("${route}/$routeOutlined") {
            TextFieldOutlinedScreen(back = back)
        }
    }
}