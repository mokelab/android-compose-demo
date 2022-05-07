package com.mokelab.demo.composables.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mokelab.demo.common.HasBackScaffold
import com.mokelab.demo.composables.R

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldOutlinedScreen(
    back: () -> Unit,
) {
    HasBackScaffold(
        title = stringResource(id = R.string.composables_textfield_outlined),
        back = back,
    ) { paddingValues ->
        var value by remember { mutableStateOf("") }

        val keyboardController = LocalSoftwareKeyboardController.current
        DisposableEffect(Unit) {
            onDispose {
                keyboardController?.hide()
            }
        }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(horizontal = 8.dp),
            value = value,
            onValueChange = { value = it },
        )
    }
}

