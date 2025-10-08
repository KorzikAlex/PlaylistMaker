package com.yandex.korzik.playlistmaker.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yandex.korzik.playlistmaker.model.ToggleMenuItem
import com.yandex.korzik.playlistmaker.utils.MenuIconRenderer

@Composable
fun MenuRowToggle(
    item: ToggleMenuItem,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    iconSize: Dp = 24.dp,
    onCheckedChange: (Boolean) -> Unit
) {
    IconTextRow(
        icon = {
            MenuIconRenderer(icon = item.icon, modifier = Modifier.size(iconSize))
        },
        title = {
            Text(
                text = stringResource(id = item.textRes),
                fontSize = fontSize,
                fontWeight = fontWeight,
                modifier = Modifier
            )
        },
        trailing = {
            Switch(
                checked = item.checked,
                onCheckedChange = onCheckedChange,
            )
        },
        modifier = modifier
    )
}