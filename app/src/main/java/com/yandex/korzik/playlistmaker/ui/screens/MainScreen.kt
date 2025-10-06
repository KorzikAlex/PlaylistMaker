package com.yandex.korzik.playlistmaker.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yandex.korzik.playlistmaker.R
import com.yandex.korzik.playlistmaker.data.PlaylistMakerUiState
import com.yandex.korzik.playlistmaker.ui.components.ColumnMainMenu
import com.yandex.korzik.playlistmaker.ui.components.PlaylistMakerTopAppBar
import com.yandex.korzik.playlistmaker.ui.theme.PlaylistMakerTheme
import com.yandex.korzik.playlistmaker.ui.viewmodel.PlaylistMakerViewModel

@Composable
fun MainScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: PlaylistMakerViewModel = viewModel(),
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.navEvents.collect { id: String ->
            when (id) {
                "search" -> navController.navigate(route = "search")
                "playlists" -> navController.navigate(route = "playlists")
                "favourites" -> navController.navigate(route = "favourites")
                "settings" -> navController.navigate(route = "settings")
            }
        }
    }

    val playlistMakerUiState: PlaylistMakerUiState by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            PlaylistMakerTopAppBar(
                title = R.string.app_name,
                colorTopBar = Color(color = 0xff3772e7)
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding: PaddingValues ->
        ColumnMainMenu(
            mainMenuItemsList = playlistMakerUiState.mainMenu,
            onActionClick = { id: String ->
                viewModel.onNavClicked(id)
            },
            modifier = Modifier.padding(paddingValues = innerPadding)
        )
    }
}

@Preview(showBackground = true, name = "MainScreen Preview", locale = "ru")
@Composable
fun MainScreenContentPreview() {
    PlaylistMakerTheme {
        MainScreen(navController = rememberNavController(), modifier = Modifier)
    }
}