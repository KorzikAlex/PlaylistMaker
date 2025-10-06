package com.yandex.korzik.playlistmaker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.yandex.korzik.playlistmaker.ui.navigation.PlaylistHost
import com.yandex.korzik.playlistmaker.ui.theme.PlaylistMakerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaylistMakerTheme {
                PlaylistHost()
            }
        }
    }
}