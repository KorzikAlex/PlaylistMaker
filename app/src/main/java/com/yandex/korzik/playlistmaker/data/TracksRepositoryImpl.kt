package com.yandex.korzik.playlistmaker.data

import com.yandex.korzik.playlistmaker.data.dto.TracksSearchRequest
import com.yandex.korzik.playlistmaker.data.dto.TracksSearchResponse
import com.yandex.korzik.playlistmaker.domain.api.TracksRepository
import com.yandex.korzik.playlistmaker.domain.models.Track

class TracksRepositoryImpl(private val networkClient: NetworkClient) : TracksRepository {
    override fun searchTracks(expression: String): List<Track> {
        val response = networkClient.doRequest(TracksSearchRequest(expression))
        if (response.resultCode == 200) { // успешный запрос
            return (response as TracksSearchResponse).results.map {
                val seconds = it.trackTimeMillis / 1000
                val minutes = seconds / 60
                val trackTime = "%02d".format(minutes) + ":" + "%02d".format(seconds - minutes * 60)
                Track(it.trackName, it.artistName, trackTime) }
        } else {
            return emptyList()
        }
    }
}