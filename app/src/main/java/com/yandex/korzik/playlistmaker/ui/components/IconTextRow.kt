package com.yandex.korzik.playlistmaker.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.yandex.korzik.playlistmaker.R

@Composable
fun IconTextRow(
    modifier: Modifier = Modifier,
    icon: (@Composable () -> Unit)? = null,
    title: @Composable () -> Unit,
    trailing: (@Composable () -> Unit)? = null,
) {

    val horizontalPadding: Dp = dimensionResource(id = R.dimen.padding_medium)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = if (icon != null) {
                    horizontalPadding
                } else {
                    0.dp
                },
                end = horizontalPadding
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        icon?.let {
            icon()
            Spacer(modifier = Modifier.width(width = horizontalPadding))
        }

        Box(modifier = Modifier.weight(weight = 1f)) {
            title()
        }

        trailing?.invoke()
    }
}