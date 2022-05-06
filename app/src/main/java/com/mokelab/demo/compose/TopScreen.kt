package com.mokelab.demo.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mokelab.demo.compose.list.ListItem
import com.mokelab.demo.compose.list.SimpleList

@Composable
fun TopScreen(navigate: (route: String) -> Unit) {
    val items = listOf(
        ListItem(
            stringResource(id = com.mokelab.demo.composables.R.string.group_composables),
            routeComposables
        ),
    )
    SimpleList(
        title = stringResource(id = R.string.app_name),
        listItems = items,
        navigate = navigate,
    )
}