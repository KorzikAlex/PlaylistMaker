package com.yandex.korzik.playlistmaker.data

import com.yandex.korzik.playlistmaker.R
import com.yandex.korzik.playlistmaker.model.MainMenuItem

class Datasource {
    fun loadMenuItems(): List<MainMenuItem> {
        return listOf(
            MainMenuItem(
                id = "search",
                iconResourceId = R.drawable.search,
                stringResourceId = R.string.search
            ),
            MainMenuItem(
                id = "playlists",
                iconResourceId = R.drawable.playlist_play,
                stringResourceId = R.string.playlist_play
            ),
            MainMenuItem(
                id = "favourites",
                iconResourceId = R.drawable.favorites,
                stringResourceId = R.string.favorite
            ),
            MainMenuItem(
                id = "settings",
                iconResourceId = R.drawable.settings,
                stringResourceId = R.string.settings
            ),
        )
    }
}