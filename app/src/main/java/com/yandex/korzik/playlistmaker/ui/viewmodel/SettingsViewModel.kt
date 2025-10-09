package com.yandex.korzik.playlistmaker.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yandex.korzik.playlistmaker.R
import com.yandex.korzik.playlistmaker.domain.impl.DefaultSettingsMenuRepository
import com.yandex.korzik.playlistmaker.domain.api.MenuRepository
import com.yandex.korzik.playlistmaker.data.dto.SettingsMenuUiState
import com.yandex.korzik.playlistmaker.domain.models.MenuItemUi
import com.yandex.korzik.playlistmaker.domain.models.UiEvent
import com.yandex.korzik.playlistmaker.ui.viewmodel.handlers.ActionHandler
import com.yandex.korzik.playlistmaker.ui.viewmodel.handlers.ToggleHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SettingsViewModel : ViewModel(), MenuViewModel, ToggleHandler, ActionHandler {
    private val _uiState: MutableStateFlow<SettingsMenuUiState> =
        MutableStateFlow(value = SettingsMenuUiState())
    override val uiState: StateFlow<SettingsMenuUiState> = this._uiState.asStateFlow()

    private val _events: MutableSharedFlow<UiEvent> = MutableSharedFlow()
    val events: SharedFlow<UiEvent> = this._events.asSharedFlow()
    override val menuRepository: MenuRepository = DefaultSettingsMenuRepository()

    init {
        this.loadMenu()
    }

    private fun sendEvent(event: UiEvent) {
        this.viewModelScope.launch {
            _events.emit(event)
        }
    }

    override fun loadMenu() {
        val settingsMenu: List<MenuItemUi> = this.menuRepository.getMenu()
        this._uiState.value = this._uiState.value.copy(
            menu = settingsMenu
        )
    }

    override fun refreshMenu(): Unit = loadMenu()
    override fun onToggleChanged(id: String, checked: Boolean) {
    }

    override fun onActionClicked(id: String) {
        when (id) {
            "share" -> sendEvent(UiEvent.OpenShare(R.string.text_share))
            "support" -> sendEvent(
                UiEvent.OpenMail(
                    emailRes = R.string.email,
                    subjectRes = R.string.subject,
                    bodyRes = R.string.body
                )
            )
            "user_agreement" -> sendEvent(UiEvent.OpenUrl(R.string.user_agreement_url))
        }
    }
}