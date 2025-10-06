package com.yandex.korzik.playlistmaker.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

sealed interface MenuIcon {
    data class Vector(val imageVector: ImageVector) : MenuIcon
    data class Drawable(@DrawableRes val resourceId: Int) : MenuIcon
}