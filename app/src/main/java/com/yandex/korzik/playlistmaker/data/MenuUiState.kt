package com.yandex.korzik.playlistmaker.data

import com.yandex.korzik.playlistmaker.model.MenuItemUi

interface MenuUiState {
    val menu: List<MenuItemUi>
}