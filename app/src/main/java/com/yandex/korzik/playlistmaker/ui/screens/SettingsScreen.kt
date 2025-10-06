package com.yandex.korzik.playlistmaker.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yandex.korzik.playlistmaker.R
import com.yandex.korzik.playlistmaker.data.PlaylistMakerUiState
import com.yandex.korzik.playlistmaker.ui.components.ColumnSettingsMenu
import com.yandex.korzik.playlistmaker.ui.components.PlaylistMakerTopAppBar
import com.yandex.korzik.playlistmaker.ui.viewmodel.PlaylistMakerViewModel

@Composable
fun SettingsScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: PlaylistMakerViewModel = viewModel()
) {
    val playlistMakerUiState: PlaylistMakerUiState by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            PlaylistMakerTopAppBar(
                title = R.string.settings,
                colorTopBar = MaterialTheme.colorScheme.background,
                colorTitle = MaterialTheme.colorScheme.onBackground
            )
        },
        modifier = modifier
    )
    { innerPadding: PaddingValues ->
        ColumnSettingsMenu(
            settingsItemsList = playlistMakerUiState.settingsMenu,
            onToggleChange = { id: String, checked: Boolean ->
                viewModel.onToggleChanged(id, checked)
            },
            onActionClick = { id: String ->
                viewModel.onActionClicked(id)
            },
            modifier = Modifier.padding(
                paddingValues = innerPadding
            )
        )
    }
}

@Preview(showSystemUi = true, showBackground = true, locale = "ru")
@Composable
fun SettingsScreenPreview() {
    SettingsScreen(navController = rememberNavController(), modifier = Modifier)
}