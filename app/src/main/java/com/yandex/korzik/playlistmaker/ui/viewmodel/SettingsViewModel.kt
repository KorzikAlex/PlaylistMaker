package com.yandex.korzik.playlistmaker.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.yandex.korzik.playlistmaker.data.DefaultSettingsMenuRepository
import com.yandex.korzik.playlistmaker.data.SettingsUiState
import com.yandex.korzik.playlistmaker.model.MenuItemUi
import com.yandex.korzik.playlistmaker.ui.viewmodel.handlers.ActionHandler
import com.yandex.korzik.playlistmaker.ui.viewmodel.handlers.ToggleHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsViewModel : ViewModel(), MenuViewModel, ToggleHandler, ActionHandler {
    private val _uiState: MutableStateFlow<SettingsUiState> =
        MutableStateFlow(value = SettingsUiState())
    override val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()

    val settingsMenuRepository = DefaultSettingsMenuRepository()

    init {
        loadMenu()
    }

    override fun loadMenu() {
        val settingsMenu: List<MenuItemUi> = settingsMenuRepository.getMenu()
        _uiState.value = _uiState.value.copy(
            menu = settingsMenu
        )
    }

    override fun refreshMenu(): Unit = loadMenu()
    override fun onToggleChanged(id: String, checked: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onActionClicked(id: String) {
        TODO("Not yet implemented")
    }
}