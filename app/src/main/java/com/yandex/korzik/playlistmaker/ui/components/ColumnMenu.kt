package com.yandex.korzik.playlistmaker.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yandex.korzik.playlistmaker.model.ActionMenuItem
import com.yandex.korzik.playlistmaker.model.MenuItemUi
import com.yandex.korzik.playlistmaker.model.ToggleMenuItem

@Composable
fun ColumnMenu(
    itemsList: List<MenuItemUi>,
    modifier: Modifier = Modifier,
    onToggleChange: (String, Boolean) -> Unit = { _, _ -> },
    onActionClick: (String) -> Unit = {}
) {
    Surface(modifier = modifier, shape = RoundedCornerShape(size = 16.dp)) {
        SimpleList(itemsList = itemsList, modifier = Modifier.fillMaxWidth()) { menuItem ->
            when (menuItem) {
                is ToggleMenuItem -> MenuRowToggle(menuItem) { checked ->
                    onToggleChange(menuItem.id, checked)
                }

                is ActionMenuItem -> MenuRowAction(menuItem) {
                    onActionClick(menuItem.id)
                }
            }
        }
    }
}