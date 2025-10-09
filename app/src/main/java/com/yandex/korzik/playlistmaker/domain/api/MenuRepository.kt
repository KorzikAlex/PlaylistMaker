package com.yandex.korzik.playlistmaker.domain.api

import com.yandex.korzik.playlistmaker.domain.models.MenuItemUi

interface MenuRepository {
    fun getMenu(): List<MenuItemUi>
}