package com.yandex.korzik.playlistmaker.ui.components

import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.yandex.korzik.playlistmaker.model.ToggleMenuItem
import com.yandex.korzik.playlistmaker.utils.MenuIconRenderer

@Composable
fun MenuRowToggle(
    item: ToggleMenuItem,
    onCheckedChange: (Boolean) -> Unit
) {
    IconTextRow(
        icon = {
            MenuIconRenderer(icon = item.icon)
        },
        title = {
            Text(text = stringResource(id = item.textRes), fontSize = 16.sp)
        },
        trailing = {
            Switch(
                checked = item.checked,
                onCheckedChange = onCheckedChange
            )
        },
        onClick = {
            onCheckedChange(!item.checked)
        }
    )
}