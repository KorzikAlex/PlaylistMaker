package com.yandex.korzik.playlistmaker.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.PlaylistPlay
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import com.yandex.korzik.playlistmaker.R
import com.yandex.korzik.playlistmaker.model.ActionMenuItem
import com.yandex.korzik.playlistmaker.model.MenuIcon
import com.yandex.korzik.playlistmaker.model.MenuItemUi

interface MainMenuRepository: MenuRepository {
    override fun getMenu(): List<MenuItemUi>
}

class DefaultMainMenuRepository : MainMenuRepository {
    override fun getMenu(): List<MenuItemUi> {
        return listOf(
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
            )
        )
    }
}