package com.yandex.korzik.playlistmaker.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun <T> SimpleList(
    itemsList: List<T>,
    modifier: Modifier = Modifier,
    content: @Composable (T) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(items = itemsList) { item ->
            content(item)
        }
    }
}