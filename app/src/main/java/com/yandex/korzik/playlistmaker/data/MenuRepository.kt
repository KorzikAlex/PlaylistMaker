package com.yandex.korzik.playlistmaker.data

import com.yandex.korzik.playlistmaker.model.MenuItemUi

interface MenuRepository {
    fun getMenu(): List<MenuItemUi>
}