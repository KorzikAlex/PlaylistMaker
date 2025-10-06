package com.yandex.korzik.playlistmaker.utils

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.yandex.korzik.playlistmaker.model.MenuIcon

@Composable
fun MenuIconRenderer(icon: MenuIcon?) {
    when (icon) {
        is MenuIcon.Vector -> Icon(
            imageVector = icon.imageVector,
            contentDescription = null
        )
        is MenuIcon.Drawable -> Icon(
            painter = painterResource(icon.resourceId),
            contentDescription = null
        )
        null -> {}
    }
}