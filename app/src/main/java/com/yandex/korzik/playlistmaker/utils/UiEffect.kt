package com.yandex.korzik.playlistmaker.utils

import android.content.Intent

sealed interface UiEffect {
    data class OpenIntent(val intent: Intent, val chooserTitle: String? = null) : UiEffect
}