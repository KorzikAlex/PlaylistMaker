package com.yandex.korzik.playlistmaker.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MainMenuItem(
    val id: String,
    @param:DrawableRes val iconResourceId: Int,
    @param:StringRes val stringResourceId: Int
)