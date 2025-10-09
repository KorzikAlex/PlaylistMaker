package com.yandex.korzik.playlistmaker.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yandex.korzik.playlistmaker.domain.impl.DefaultMainMenuRepository
import com.yandex.korzik.playlistmaker.data.dto.MainMenuUiState
import com.yandex.korzik.playlistmaker.domain.api.MenuRepository
import com.yandex.korzik.playlistmaker.domain.models.MenuItemUi
import com.yandex.korzik.playlistmaker.ui.viewmodel.handlers.NavigationHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainMenuViewModel : ViewModel(), MenuViewModel, NavigationHandler {
    private val _uiState: MutableStateFlow<MainMenuUiState> =
        MutableStateFlow(value = MainMenuUiState())
    override val uiState: StateFlow<MainMenuUiState> = this._uiState.asStateFlow()

    private val _navEvents: MutableSharedFlow<String> = MutableSharedFlow()
    val navEvents: SharedFlow<String> = this._navEvents.asSharedFlow()

    override val menuRepository: MenuRepository = DefaultMainMenuRepository()

    init {
        this.loadMenu()
    }

    override fun loadMenu() {
        val mainMenu: List<MenuItemUi> = menuRepository.getMenu()
        this._uiState.value = _uiState.value.copy(
            menu = mainMenu
        )
    }

    override fun onNavClicked(route: String) {
        this.viewModelScope.launch {
            _navEvents.emit(
                value = route
            )
        }
    }

    override fun refreshMenu(): Unit = this.loadMenu()
}