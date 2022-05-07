package com.mokelab.demo.composables.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mokelab.demo.composables.R
import com.mokelab.demo.composables.routeContained
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
    )
    SimpleList(
        title = stringResource(id = R.string.composables_button),
        listItems = items,
        back = back,
        navigate = navigate
    )
}