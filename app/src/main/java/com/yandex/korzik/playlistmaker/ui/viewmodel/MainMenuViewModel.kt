package com.yandex.korzik.playlistmaker.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yandex.korzik.playlistmaker.data.DefaultMainMenuRepository
import com.yandex.korzik.playlistmaker.data.MainMenuUiState
import com.yandex.korzik.playlistmaker.model.MenuItemUi
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
    override val uiState: StateFlow<MainMenuUiState> = _uiState.asStateFlow()

    private val _navEvents: MutableSharedFlow<String> = MutableSharedFlow()
    val navEvents: SharedFlow<String> = _navEvents.asSharedFlow()

    private val mainMenuRepository: DefaultMainMenuRepository = DefaultMainMenuRepository()

    init {
        loadMenu()
    }

    override fun loadMenu() {
        val mainMenu: List<MenuItemUi> = mainMenuRepository.getMenu()
        _uiState.value = _uiState.value.copy(
            menu = mainMenu
        )
    }

    override fun onNavClicked(route: String) {
        viewModelScope.launch {
            _navEvents.emit(
                value = route
            )
        }
    }

    override fun refreshMenu(): Unit = loadMenu()
}