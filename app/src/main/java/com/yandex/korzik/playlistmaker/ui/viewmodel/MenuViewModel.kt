package com.yandex.korzik.playlistmaker.ui.viewmodel

import com.yandex.korzik.playlistmaker.data.MenuUiState
import kotlinx.coroutines.flow.StateFlow

interface MenuViewModel {
    val uiState: StateFlow<MenuUiState>
    fun loadMenu()
    fun refreshMenu()
}