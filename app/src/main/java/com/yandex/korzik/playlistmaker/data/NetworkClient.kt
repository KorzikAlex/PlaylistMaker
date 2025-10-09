package com.yandex.korzik.playlistmaker.data

import com.yandex.korzik.playlistmaker.data.dto.BaseResponse

interface NetworkClient {
    fun doRequest(dto: Any): BaseResponse
}