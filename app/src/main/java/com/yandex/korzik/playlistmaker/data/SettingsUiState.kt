package com.yandex.korzik.playlistmaker.data

import com.yandex.korzik.playlistmaker.model.MenuItemUi

data class SettingsUiState(
    override val menu: List<MenuItemUi> = emptyList()
) : MenuUiState