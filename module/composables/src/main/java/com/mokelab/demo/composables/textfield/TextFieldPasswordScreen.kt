package com.mokelab.demo.composables.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.mokelab.demo.common.HasBackScaffold
import com.mokelab.demo.composables.R

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldPasswordScreen(
    back: () -> Unit,
) {
    HasBackScaffold(
        title = stringResource(id = R.string.composables_textfield_placeholder),
        back = back,
    ) { paddingValues ->
        var value by remember { mutableStateOf("") }

        val focusManager = LocalFocusManager.current
        val keyboardController = LocalSoftwareKeyboardController.current
        DisposableEffect(Unit) {
            onDispose {
                keyboardController?.hide()
            }
        }

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(horizontal = 8.dp),
            label = {
                Text(stringResource(id = R.string.password))
            },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password,
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.moveFocus(FocusDirection.Down)
                    keyboardController?.hide()
                }
            ),
            value = value,
            onValueChange = { value = it },
        )
    }
}

