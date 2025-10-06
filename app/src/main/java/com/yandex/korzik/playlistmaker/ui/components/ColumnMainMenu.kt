package com.yandex.korzik.playlistmaker.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yandex.korzik.playlistmaker.model.MenuItemUi

@Composable
fun ColumnMainMenu(
    mainMenuItemsList: List<MenuItemUi>,
    modifier: Modifier = Modifier,
    onActionClick: (String) -> Unit = {}
) {
    ColumnMenu(
        itemsList = mainMenuItemsList,
        modifier = modifier,
        onActionClick = onActionClick
    )
}