package com.yandex.korzik.playlistmaker.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed interface MenuItemUi {
    val id: String

    @get:StringRes
    val textRes: Int

    val icon: MenuIcon?

    @get:StringRes
    val contentDescriptionRes: Int?
}