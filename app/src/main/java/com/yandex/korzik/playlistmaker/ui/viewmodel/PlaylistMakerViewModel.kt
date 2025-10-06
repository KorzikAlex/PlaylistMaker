package com.yandex.korzik.playlistmaker.ui.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.PlaylistPlay
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.SupportAgent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yandex.korzik.playlistmaker.R
import com.yandex.korzik.playlistmaker.data.PlaylistMakerUiState
import com.yandex.korzik.playlistmaker.model.ActionMenuItem
import com.yandex.korzik.playlistmaker.model.MenuIcon
import com.yandex.korzik.playlistmaker.model.MenuItemUi
import com.yandex.korzik.playlistmaker.model.ToggleMenuItem
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PlaylistMakerViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<PlaylistMakerUiState> =
        MutableStateFlow(value = PlaylistMakerUiState())
    val uiState: StateFlow<PlaylistMakerUiState> = _uiState.asStateFlow()

    private val _navEvents: MutableSharedFlow<String> = MutableSharedFlow()
    val navEvents: SharedFlow<String> = _navEvents.asSharedFlow()

    init {
        loadMenus()
    }

    private fun loadMenus() {
        val main: List<MenuItemUi> = listOf(
            ActionMenuItem(
                id = "search",
                textRes = R.string.search,
                icon = MenuIcon.Vector(imageVector = Icons.Default.Search)
            ),
            ActionMenuItem(
                id = "playlists",
                textRes = R.string.playlist_play,
                icon = MenuIcon.Vector(imageVector = Icons.AutoMirrored.Filled.PlaylistPlay)
            ),
            ActionMenuItem(
                id = "favourites",
                textRes = R.string.favorite,
                icon = MenuIcon.Vector(imageVector = Icons.Default.FavoriteBorder)
            ),
            ActionMenuItem(
                id = "settings",
                textRes = R.string.settings,
                icon = MenuIcon.Vector(imageVector = Icons.Default.Settings)
            ),
        )

        val settings: List<MenuItemUi> = listOf(
            ToggleMenuItem(id = "theme", textRes = R.string.dark_theme, checked = false),
            ActionMenuItem(
                id = "share",
                textRes = R.string.share_app,
                trailingIcon = MenuIcon.Vector(imageVector = Icons.Default.Share)
            ),
            ActionMenuItem(
                id = "support",
                textRes = R.string.support,
                trailingIcon = MenuIcon.Vector(imageVector = Icons.Default.SupportAgent)
            ),
            ActionMenuItem(id = "user_agreement", textRes = R.string.user_agreement)
        )

        _uiState.value = _uiState.value.copy(
            mainMenu = main,
            settingsMenu = settings
        )
    }

    // Обработка переключателя в настройках
    fun onToggleChanged(id: String, checked: Boolean) {
        println("Toggle $id changed: $checked")
    }

    fun onActionClicked(id: String) {
        println("Action $id clicked")
    }

    fun onNavClicked(id: String) {
        viewModelScope.launch {
            _navEvents.emit(id) // эмитируем событие навигации
        }
    }

    fun refreshMenus(): Unit = loadMenus()
}