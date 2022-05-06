package com.mokelab.demo.composables.text

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.mokelab.demo.common.HasBackScaffold
import com.mokelab.demo.composables.R

@Composable
fun TextColor(
    back: () -> Unit,
) {
    HasBackScaffold(
        title = stringResource(id = R.string.composables_text_color),
        back = back,
    ) { paddingValues ->
        Text(
            text = stringResource(id = R.string.composables_text_hello),
            color = Color(red = 255, green = 0, blue = 255),
            modifier = Modifier.padding(paddingValues),
        )
    } // end of Scaffold
}