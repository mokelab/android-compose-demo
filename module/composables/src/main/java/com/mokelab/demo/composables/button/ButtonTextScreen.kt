package com.mokelab.demo.composables.button

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.mokelab.demo.common.HasBackScaffold
import com.mokelab.demo.composables.R

@Composable
fun ButtonTextScreen(
    back: () -> Unit,
) {
    val context = LocalContext.current
    HasBackScaffold(
        title = stringResource(id = R.string.composables_button_text),
        back = back,
    ) { paddingValues ->
        TextButton(
            modifier = Modifier.padding(paddingValues),
            onClick = {
                Toast.makeText(context, "Clicked!", Toast.LENGTH_SHORT).show()
            },
        ) {
            Text(stringResource(id = android.R.string.ok))
        }
    }
}