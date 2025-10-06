package com.yandex.korzik.playlistmaker.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun SearchTextField(modifier: Modifier = Modifier) {
    val message by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = message,
        onValueChange = {},
        placeholder = { Text(text = "Поиск") },
        modifier = modifier,
        maxLines = 1,
        singleLine = true,
        enabled = true,
        isError = false,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier
            )
        },
        trailingIcon = {
            IconButton(modifier = Modifier, onClick = {}) {
                Icon(imageVector = Icons.Default.Clear, contentDescription = null)
            }
        }
    )
}