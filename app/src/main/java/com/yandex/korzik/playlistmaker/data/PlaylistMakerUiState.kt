package com.yandex.korzik.playlistmaker.data

import com.yandex.korzik.playlistmaker.model.MenuItemUi

data class PlaylistMakerUiState (
    val mainMenu: List<MenuItemUi> = emptyList(),
    val settingsMenu: List<MenuItemUi> = emptyList(),
    val selectedMainMenuId: String? = null,
    val selectedSettingsMenuId: String? = null
)