package com.yandex.korzik.playlistmaker.data.dto

import com.yandex.korzik.playlistmaker.domain.models.MenuItemUi

data class MainMenuUiState(
    override val menu: List<MenuItemUi> = emptyList(),
) : MenuUiState