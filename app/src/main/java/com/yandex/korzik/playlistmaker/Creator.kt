package com.yandex.korzik.playlistmaker

import com.yandex.korzik.playlistmaker.data.TracksRepositoryImpl
import com.yandex.korzik.playlistmaker.data.network.RetrofitNetworkClient
import com.yandex.korzik.playlistmaker.domain.api.TrackSearchInteractor
import com.yandex.korzik.playlistmaker.domain.api.TracksRepository
import com.yandex.korzik.playlistmaker.domain.impl.TrackSearchInteractorImpl

object Creator {
    private fun getTracksRepository(): TracksRepository {
        return TracksRepositoryImpl(RetrofitNetworkClient())
    }

    fun provideTrackSearchInteractor(): TrackSearchInteractor {
        return TrackSearchInteractorImpl(getTracksRepository())
    }
}