package com.yandex.korzik.playlistmaker.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.SupportAgent
import com.yandex.korzik.playlistmaker.R
import com.yandex.korzik.playlistmaker.model.ActionMenuItem
import com.yandex.korzik.playlistmaker.model.MenuIcon
import com.yandex.korzik.playlistmaker.model.MenuItemUi
import com.yandex.korzik.playlistmaker.model.ToggleMenuItem

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
                trailingIcon = MenuIcon.Vector(imageVector = Icons.Default.Share)
            ),
            ActionMenuItem(
                id = "support",
                textRes = R.string.support,
                trailingIcon = MenuIcon.Vector(imageVector = Icons.Default.SupportAgent)
            ),
            ActionMenuItem(id = "user_agreement", textRes = R.string.user_agreement)
        )
    }
}