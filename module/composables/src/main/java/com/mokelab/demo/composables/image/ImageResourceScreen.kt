package com.mokelab.demo.composables.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.mokelab.demo.common.HasBackScaffold
import com.mokelab.demo.composables.R

@Composable
fun ImageResourceScreen(
    back: () -> Unit,
) {
    HasBackScaffold(
        title = stringResource(id = R.string.composables_image_resource),
        back = back,
    ) { paddingValues ->
        Image(
            painter = painterResource(id = R.drawable.moke),
            contentDescription = "Mokera!",
            modifier = Modifier.padding(paddingValues),
        )
    }
}