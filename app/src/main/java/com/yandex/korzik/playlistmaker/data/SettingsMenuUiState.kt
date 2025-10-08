package com.yandex.korzik.playlistmaker.data

import com.yandex.korzik.playlistmaker.model.MenuItemUi

data class SettingsMenuUiState(
    override val menu: List<MenuItemUi> = emptyList()
) : MenuUiState