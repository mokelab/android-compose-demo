package com.mokelab.demo.compose.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleList(
    title: String,
    listItems: List<ListItem>,
    back: (() -> Unit)? = null,
    navigate: (route: String) -> Unit,
) {
    val scrollBehavior = remember { TopAppBarDefaults.pinnedScrollBehavior() }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(title)
                },
                navigationIcon = {
                    if (back != null) {
                        IconButton(onClick = back) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }

                },
                scrollBehavior = scrollBehavior
            )
        }
    ) {
        LazyColumn(
            contentPadding = it
        ) {
            items(listItems) { item ->
                Box(modifier = Modifier
                    .fillParentMaxWidth()
                    .height(48.dp)
                    .clickable {
                        navigate(item.route)
                    }
                ) {
                    Text(
                        item.label, modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(horizontal = 16.dp)
                    )
                    Divider(modifier = Modifier.align(Alignment.BottomStart))
                }
            }
        }
    } // end of Scaffold
}

