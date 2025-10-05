package com.yandex.korzik.playlistmaker.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.yandex.korzik.playlistmaker.data.PlaylistMakerUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PlaylistMakerViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(value = PlaylistMakerUiState())
    val uiState: StateFlow<PlaylistMakerUiState> = _uiState.asStateFlow()
}