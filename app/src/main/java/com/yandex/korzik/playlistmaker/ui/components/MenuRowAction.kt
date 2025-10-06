package com.yandex.korzik.playlistmaker.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.yandex.korzik.playlistmaker.R
import com.yandex.korzik.playlistmaker.model.ActionMenuItem
import com.yandex.korzik.playlistmaker.utils.MenuIconRenderer

@Composable
fun MenuRowAction(
    item: ActionMenuItem,
    onAction: () -> Unit
) {
    IconTextRow(
        icon = {
            MenuIconRenderer(icon = item.icon)
        },
        title = {
            Text(
                text = stringResource(
                    id = item.textRes
                ),
                fontSize = 16.sp
            )
        },
        trailing = {
            item.trailingIcon?.let {
                IconButton(
                    onClick = onAction
                ) {
                    MenuIconRenderer(
                        icon = it
                    )
                }
            } ?: IconButton(
                onClick = onAction
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                    contentDescription = stringResource(id = R.string.next),
                )
            }
        },
        onClick = onAction
    )
}