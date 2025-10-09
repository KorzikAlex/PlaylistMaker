package com.yandex.korzik.playlistmaker.domain.models

import androidx.annotation.StringRes

sealed interface MenuItemUi {
    val id: String

    @get:StringRes
    val textRes: Int

    @get:StringRes
    val contentDescriptionRes: Int?
}