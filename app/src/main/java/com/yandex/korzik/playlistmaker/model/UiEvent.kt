package com.yandex.korzik.playlistmaker.model

import androidx.annotation.StringRes

sealed interface UiEvent {
    data class OpenShare(@param:StringRes val textRes: Int) : UiEvent
    data class OpenMail(
        @param:StringRes
        val emailRes: Int,
        @param:StringRes
        val subjectRes: Int,
        @param:StringRes
        val bodyRes: Int
    ) : UiEvent

    data class OpenUrl(@param:StringRes val urlRes: Int) : UiEvent
}