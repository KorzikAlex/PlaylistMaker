package com.yandex.korzik.playlistmaker.ui.viewmodel

import kotlinx.coroutines.flow.StateFlow

interface ViewModelInterface {
    val uiState: StateFlow<*>
}