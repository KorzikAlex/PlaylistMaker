package com.yandex.korzik.playlistmaker.domain.impl

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.PlaylistPlay
import androidx.compose.material.icons.automirrored.rounded.ArrowForwardIos
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import com.yandex.korzik.playlistmaker.R
import com.yandex.korzik.playlistmaker.domain.api.MenuRepository
import com.yandex.korzik.playlistmaker.domain.models.ActionMenuItem
import com.yandex.korzik.playlistmaker.domain.models.MenuIcon
import com.yandex.korzik.playlistmaker.domain.models.MenuItemUi

interface MainMenuRepository : MenuRepository {
    override fun getMenu(): List<MenuItemUi>
}

class DefaultMainMenuRepository : MainMenuRepository {
    override fun getMenu(): List<MenuItemUi> {
        return listOf(
            ActionMenuItem(
                id = "search",
                textRes = R.string.search,
                icon = MenuIcon.Vector(imageVector = Icons.Default.Search),
                trailingIcon = MenuIcon.Vector(imageVector = Icons.AutoMirrored.Rounded.ArrowForwardIos),
                contentDescriptionRes = R.string.search
            ),
            ActionMenuItem(
                id = "playlists",
                textRes = R.string.playlist_play,
                icon = MenuIcon.Vector(imageVector = Icons.AutoMirrored.Filled.PlaylistPlay),
                trailingIcon = MenuIcon.Vector(imageVector = Icons.AutoMirrored.Rounded.ArrowForwardIos),
                contentDescriptionRes = R.string.playlist_play
            ),
            ActionMenuItem(
                id = "favourites",
                textRes = R.string.favorite,
                icon = MenuIcon.Vector(imageVector = Icons.Default.FavoriteBorder),
                trailingIcon = MenuIcon.Vector(imageVector = Icons.AutoMirrored.Rounded.ArrowForwardIos),
                contentDescriptionRes = R.string.favorite
            ),
            ActionMenuItem(
                id = "settings",
                textRes = R.string.settings,
                icon = MenuIcon.Vector(imageVector = Icons.Default.Settings),
                trailingIcon = MenuIcon.Vector(imageVector = Icons.AutoMirrored.Rounded.ArrowForwardIos),
                contentDescriptionRes = R.string.settings
            )
        )
    }
}