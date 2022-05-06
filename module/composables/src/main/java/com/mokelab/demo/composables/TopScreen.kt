package com.mokelab.demo.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mokelab.demo.compose.list.ListItem
import com.mokelab.demo.compose.list.SimpleList

@Composable
fun TopScreen(
    routePrefix: String,
    back: () -> Unit,
    navigate: (route: String) -> Unit,
) {
    val items = listOf(
        ListItem(stringResource(id = R.string.composables_text), "${routePrefix}/${routeText}")
    )
    SimpleList(
        title = stringResource(id = R.string.group_composables),
        listItems = items,
        back = back,
        navigate = navigate
    )
}