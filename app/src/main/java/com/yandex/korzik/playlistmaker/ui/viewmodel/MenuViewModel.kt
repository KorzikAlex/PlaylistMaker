package com.yandex.korzik.playlistmaker.ui.viewmodel

import com.yandex.korzik.playlistmaker.domain.api.MenuRepository
import com.yandex.korzik.playlistmaker.data.dto.MenuUiState
import kotlinx.coroutines.flow.StateFlow

interface MenuViewModel: ViewModelInterface {
    override val uiState: StateFlow<MenuUiState>
    val menuRepository: MenuRepository
    fun loadMenu()
    fun refreshMenu()

}