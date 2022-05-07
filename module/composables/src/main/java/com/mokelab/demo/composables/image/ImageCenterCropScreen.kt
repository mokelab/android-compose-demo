package com.mokelab.demo.composables.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mokelab.demo.common.HasBackScaffold
import com.mokelab.demo.composables.R

@Composable
fun ImageCenterCropScreen(
    back: () -> Unit,
) {
    HasBackScaffold(
        title = stringResource(id = R.string.composables_image_resource),
        back = back,
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
        ) {
            Image(
                painter = painterResource(id = R.drawable.moke),
                contentDescription = "Mokera!",
            )
            // center crop
            Image(
                painter = painterResource(id = R.drawable.moke),
                contentDescription = "Mokera!",
                modifier = Modifier.size(256.dp, 128.dp),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
        }
    }
}