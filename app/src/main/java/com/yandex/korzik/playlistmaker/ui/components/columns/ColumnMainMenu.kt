package com.yandex.korzik.playlistmaker.ui.components.columns

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yandex.korzik.playlistmaker.domain.models.MenuItemUi

@Composable
fun ColumnMainMenu(
    mainMenuItemsList: List<MenuItemUi>,
    modifier: Modifier = Modifier,
    onActionClick: (String) -> Unit = {}
) {
    ColumnMenu(
        itemsList = mainMenuItemsList,
        modifier = modifier,
        onActionClick = onActionClick,
        fontSize = 24.sp,
        iconSize = 24.dp,
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        fontWeight = FontWeight.Bold
    )
}