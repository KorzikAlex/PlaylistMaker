package com.yandex.korzik.playlistmaker.model

import androidx.annotation.StringRes

data class ToggleMenuItem(
    override val id: String,

    @param:StringRes
    override val textRes: Int,

    val icon: MenuIcon? = null,

    @param:StringRes
    override val contentDescriptionRes: Int? = textRes,

    val checked: Boolean = false,
) : MenuItemUi
