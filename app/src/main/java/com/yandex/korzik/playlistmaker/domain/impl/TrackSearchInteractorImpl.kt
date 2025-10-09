package com.yandex.korzik.playlistmaker.domain.impl

import com.yandex.korzik.playlistmaker.domain.api.TrackSearchInteractor
import com.yandex.korzik.playlistmaker.domain.api.TracksRepository
import com.yandex.korzik.playlistmaker.domain.models.Track

class TrackSearchInteractorImpl(private val repository: TracksRepository) : TrackSearchInteractor {

    override fun searchTracks(expression: String): List<Track> {
        return repository.searchTracks(expression)
    }
}