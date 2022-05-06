package com.mokelab.demo.composables.text

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.mokelab.demo.common.HasBackScaffold
import com.mokelab.demo.composables.R

@Composable
fun TextSize(
    back: () -> Unit,
) {
    HasBackScaffold(
        title = stringResource(id = R.string.composables_text_size),
        back = back,
    ) { paddingValues ->
        Text(
            text = stringResource(id = R.string.composables_text_hello),
            fontSize = 32.sp,
            modifier = Modifier.padding(paddingValues),
        )
    } // end of Scaffold
}