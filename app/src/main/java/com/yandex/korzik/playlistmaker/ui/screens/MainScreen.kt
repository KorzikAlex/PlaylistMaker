package com.yandex.korzik.playlistmaker.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yandex.korzik.playlistmaker.R
import com.yandex.korzik.playlistmaker.data.Datasource
import com.yandex.korzik.playlistmaker.model.MainMenuItem
import com.yandex.korzik.playlistmaker.ui.components.MainMenuItemRes
import com.yandex.korzik.playlistmaker.ui.components.PlayListMakerTopAppBar
import com.yandex.korzik.playlistmaker.ui.components.SimpleList
import com.yandex.korzik.playlistmaker.ui.theme.PlaylistMakerTheme
import com.yandex.korzik.playlistmaker.ui.viewmodel.PlaylistMakerViewModel

@Composable
fun ColumnMainMenu(
    mainMenuItemsList: List<MainMenuItem>,
    modifier: Modifier = Modifier,
    onItemClick: (MainMenuItem) -> Unit = {},
) {
    Surface(modifier = modifier, shape = RoundedCornerShape(size = 16.dp)) {
        SimpleList(itemsList = mainMenuItemsList, modifier = Modifier.fillMaxWidth()) { menuItem ->
            MainMenuItemRes(
                iconRes = menuItem.iconResourceId,
                textRes = menuItem.stringResourceId,
                onClick = { onItemClick(menuItem) }
            )
        }
    }
}

@Composable
fun MainScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: PlaylistMakerViewModel = viewModel(),
) {
    val mainMenuItems = Datasource().loadMenuItems()
    Scaffold(
        topBar = {
            PlayListMakerTopAppBar(title = R.string.app_name)
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        ColumnMainMenu(
            mainMenuItemsList = mainMenuItems,
            modifier = Modifier.padding(paddingValues = innerPadding),
            onItemClick = { menuItem ->
                when (menuItem.id) {
                    "playlists" -> navController.navigate(route = "playlists")
                    "favourites" -> navController.navigate(route = "favourites")
                    "settings" -> navController.navigate(route = "settings")
                    "search" -> navController.navigate(route = "search")
                }
            }
        )
    }
}

@Preview(showBackground = true, name = "MainScreen Preview")
@Composable
fun MainScreenContentPreview() {
    PlaylistMakerTheme {
        val navController = rememberNavController()
        MainScreen(navController = navController, modifier = Modifier)
    }
}