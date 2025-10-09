package com.yandex.korzik.playlistmaker.data.dto

import com.yandex.korzik.playlistmaker.domain.models.MenuItemUi

data class SettingsMenuUiState(
    override val menu: List<MenuItemUi> = emptyList()
) : MenuUiState