package com.yandex.korzik.playlistmaker.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yandex.korzik.playlistmaker.R
import com.yandex.korzik.playlistmaker.model.ActionMenuItem
import com.yandex.korzik.playlistmaker.model.MenuItemUi
import com.yandex.korzik.playlistmaker.model.ToggleMenuItem

@Composable
fun ColumnMenu(
    itemsList: List<MenuItemUi>,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    shape: RoundedCornerShape = RoundedCornerShape(size = 0.dp),
    iconSize: Dp = 24.dp,
    onToggleChange: (String, Boolean) -> Unit = { _, _ -> },
    onActionClick: (String) -> Unit = {}
) {
    Surface(modifier = modifier, shape = shape) {
        SimpleList(
            itemsList = itemsList,
            modifier = Modifier.fillMaxWidth()
        ) { menuItem: MenuItemUi ->
            when (menuItem) {
                is ToggleMenuItem -> MenuRowToggle(
                    menuItem,
                    fontWeight = fontWeight,
                    fontSize = fontSize,
                    iconSize = iconSize,
                    modifier = Modifier.padding(
                        vertical = dimensionResource(id = R.dimen.padding_medium)
                    )
                ) { checked: Boolean ->
                    onToggleChange(menuItem.id, checked)
                }

                is ActionMenuItem -> MenuRowAction(
                    menuItem,
                    fontWeight = fontWeight,
                    fontSize = fontSize,
                    iconSize = iconSize,
                    modifier = Modifier.padding(
                        vertical = dimensionResource(id = R.dimen.padding_medium)
                    )
                ) {
                    onActionClick(menuItem.id)
                }
            }
        }
    }
}