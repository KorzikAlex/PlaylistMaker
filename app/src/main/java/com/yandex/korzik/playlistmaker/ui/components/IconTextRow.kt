package com.yandex.korzik.playlistmaker.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.yandex.korzik.playlistmaker.R

@Composable
fun IconTextRow(
    modifier: Modifier = Modifier,
    icon: (@Composable () -> Unit)? = null,
    title: @Composable () -> Unit,
    trailing: (@Composable () -> Unit)? = null,
    onClick: (() -> Unit)? = null
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .then(
                other = if (onClick != null) {
                    Modifier.clickable {
                        onClick()
                    }
                } else {
                    Modifier
                }
            )
            .padding(
                horizontal = dimensionResource(id = R.dimen.padding_medium),
                vertical = dimensionResource(id = R.dimen.padding_medium)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon?.invoke()
        if (icon != null) {
            Spacer(modifier = Modifier.width(width = dimensionResource(id = R.dimen.padding_medium)))
        }

        Box(modifier = Modifier.weight(weight = 1f)) {
            title()
        }

        trailing?.invoke()
    }
}