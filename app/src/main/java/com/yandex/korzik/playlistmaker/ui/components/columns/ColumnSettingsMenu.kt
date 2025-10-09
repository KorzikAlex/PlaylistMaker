package com.yandex.korzik.playlistmaker.ui.components.columns

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yandex.korzik.playlistmaker.domain.models.MenuItemUi

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
        onActionClick = onActionClick,
        fontSize = 20.sp,
        iconSize = 24.dp,
        fontWeight = FontWeight.Normal
    )
}