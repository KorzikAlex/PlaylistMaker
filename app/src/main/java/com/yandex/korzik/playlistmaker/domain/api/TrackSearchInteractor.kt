package com.yandex.korzik.playlistmaker.domain.api

import com.yandex.korzik.playlistmaker.domain.models.Track

interface TrackSearchInteractor {
    fun searchTracks(expression: String): List<Track>
}