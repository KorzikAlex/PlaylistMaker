package com.yandex.korzik.playlistmaker.ui.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun SearchTextField(
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    onClearClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = searchText,
        onValueChange = onSearchTextChange,
        placeholder = {
            Text(text = "Поиск")
        },
        modifier = modifier,
        maxLines = 1,
        singleLine = true,
        enabled = true,
        isError = false,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search,
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                focusManager.clearFocus()
                keyboardController?.hide()
            }
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier
            )
        },
        trailingIcon = {
            if (searchText.isNotEmpty()) {
                IconButton(modifier = Modifier, onClick = {
                    onClearClick()
                }) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                }
            }
        }
    )
}