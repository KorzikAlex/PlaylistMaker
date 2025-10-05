package com.yandex.korzik.playlistmaker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yandex.korzik.playlistmaker.ui.screens.FavouritesScreen
import com.yandex.korzik.playlistmaker.ui.screens.MainScreen
import com.yandex.korzik.playlistmaker.ui.screens.PlaylistsScreen
import com.yandex.korzik.playlistmaker.ui.screens.SearchScreen
import com.yandex.korzik.playlistmaker.ui.screens.SettingsScreen

sealed class Screen(val route: String) {
    object Main : Screen(route = "main")
    object Search : Screen(route = "search")
    object Playlists : Screen(route = "playlists")
    object Favourites : Screen(route = "favourites")
    object Settings : Screen(route = "settings")
}

@Composable
fun AppNavGraph(
    navHostController: NavHostController = rememberNavController(),
    startDestination: Screen = Screen.Main
) {
    NavHost(navController = navHostController, startDestination = startDestination.route) {
        composable(route = Screen.Main.route) {
            MainScreen(navController = navHostController, modifier = Modifier)
        }
        composable(route = Screen.Settings.route) {
            SettingsScreen(navController = navHostController, modifier = Modifier)
        }
        composable(route = Screen.Playlists.route) {
            PlaylistsScreen(navController = navHostController, modifier = Modifier)
        }
        composable(route = Screen.Favourites.route) {
            FavouritesScreen(navController = navHostController, modifier = Modifier)
        }
        composable(route = Screen.Search.route) {
            SearchScreen(navController = navHostController, modifier = Modifier)
        }
    }
}