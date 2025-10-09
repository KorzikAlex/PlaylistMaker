package com.yandex.korzik.playlistmaker.ui.utils

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.yandex.korzik.playlistmaker.domain.models.MenuIcon

@Composable
fun MenuIconRenderer(
    icon: MenuIcon?,
    modifier: Modifier = Modifier,
    contentDescription: String? = null
) {
    when (icon) {
        is MenuIcon.Vector -> Icon(
            imageVector = icon.imageVector,
            contentDescription = contentDescription,
            modifier = modifier
        )

        is MenuIcon.Drawable -> Icon(
            painter = painterResource(icon.resourceId),
            contentDescription = contentDescription,
            modifier = modifier
        )

        null -> {}
    }
}