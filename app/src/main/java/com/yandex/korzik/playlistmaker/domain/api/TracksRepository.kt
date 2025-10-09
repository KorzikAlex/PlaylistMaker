package com.yandex.korzik.playlistmaker.domain.api

import com.yandex.korzik.playlistmaker.domain.models.Track

interface TracksRepository {
    fun searchTracks(expression: String): List<Track>
}