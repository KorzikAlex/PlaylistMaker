package com.yandex.korzik.playlistmaker.data.network

import com.yandex.korzik.playlistmaker.data.NetworkClient

class RetrofitNetworkClient : NetworkClient {
    override fun doRequest(dto: Any): Response {
        return TrackSearchResponse(listOf())
    }
}