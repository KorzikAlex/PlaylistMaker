package com.yandex.korzik.playlistmaker.domain.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

sealed interface MenuIcon {
    data class Vector(val imageVector: ImageVector) : MenuIcon
    data class Drawable(@param:DrawableRes val resourceId: Int) : MenuIcon
}