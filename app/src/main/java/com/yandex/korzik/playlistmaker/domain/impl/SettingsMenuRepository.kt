package com.yandex.korzik.playlistmaker.domain.impl

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.SupportAgent
import com.yandex.korzik.playlistmaker.R
import com.yandex.korzik.playlistmaker.domain.api.MenuRepository
import com.yandex.korzik.playlistmaker.domain.models.ActionMenuItem
import com.yandex.korzik.playlistmaker.domain.models.MenuIcon
import com.yandex.korzik.playlistmaker.domain.models.MenuItemUi
import com.yandex.korzik.playlistmaker.domain.models.ToggleMenuItem

interface SettingsMenuRepository : MenuRepository {
    override fun getMenu(): List<MenuItemUi>;
}

class DefaultSettingsMenuRepository : SettingsMenuRepository {
    override fun getMenu(): List<MenuItemUi> {
        return listOf(
            ToggleMenuItem(id = "theme", textRes = R.string.dark_theme, checked = false),
            ActionMenuItem(
                id = "share",
                textRes = R.string.share_app,
                trailingIcon = MenuIcon.Vector(imageVector = Icons.Rounded.Share),
                contentDescriptionRes = R.string.share_app
            ),
            ActionMenuItem(
                id = "support",
                textRes = R.string.support,
                trailingIcon = MenuIcon.Vector(imageVector = Icons.Rounded.SupportAgent),
                contentDescriptionRes = R.string.support
            ),
            ActionMenuItem(
                id = "user_agreement",
                textRes = R.string.user_agreement,
                trailingIcon = MenuIcon.Vector(imageVector = Icons.AutoMirrored.Rounded.ArrowForwardIos),
                contentDescriptionRes = R.string.user_agreement
            )
        )
    }
}