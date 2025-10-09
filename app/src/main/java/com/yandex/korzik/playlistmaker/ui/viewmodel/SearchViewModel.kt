package com.yandex.korzik.playlistmaker.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.yandex.korzik.playlistmaker.data.dto.SearchUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel : ViewModel(), ViewModelInterface {
    private val _uiState: MutableStateFlow<SearchUiState> = MutableStateFlow(SearchUiState())
    override val uiState: StateFlow<SearchUiState> = this._uiState.asStateFlow()

    fun onSearchTextChanged(newText: String) {
        this._uiState.value = _uiState.value.copy(searchText = newText)
    }

    fun onClearClick(): Unit = this.onSearchTextChanged("")
}