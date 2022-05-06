package com.mokelab.demo.composables.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mokelab.demo.composables.R
import com.mokelab.demo.composables.routeColor
import com.mokelab.demo.composables.routeDisplay
import com.mokelab.demo.composables.routeSize
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