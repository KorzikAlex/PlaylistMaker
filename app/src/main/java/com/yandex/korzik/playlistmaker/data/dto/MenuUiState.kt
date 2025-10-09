package com.yandex.korzik.playlistmaker.data.dto

import com.yandex.korzik.playlistmaker.domain.models.MenuItemUi

interface MenuUiState {
    val menu: List<MenuItemUi>
}