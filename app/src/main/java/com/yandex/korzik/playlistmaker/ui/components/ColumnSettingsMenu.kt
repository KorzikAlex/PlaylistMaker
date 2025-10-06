package com.yandex.korzik.playlistmaker.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yandex.korzik.playlistmaker.model.MenuItemUi

@Composable
fun ColumnSettingsMenu(
    settingsItemsList: List<MenuItemUi>,
    modifier: Modifier = Modifier,
    onToggleChange: (String, Boolean) -> Unit = { _, _ -> },
    onActionClick: (String) -> Unit = {}
) {
    ColumnMenu(
        itemsList = settingsItemsList,
        modifier = modifier,
        onToggleChange = onToggleChange,
        onActionClick = onActionClick
    )
}