package com.yandex.korzik.playlistmaker.data

import com.yandex.korzik.playlistmaker.model.MenuItemUi

data class MainMenuUiState(
    override val menu: List<MenuItemUi> = emptyList(),
    val settingsMenu: List<MenuItemUi> = emptyList(),
) : MenuUiState