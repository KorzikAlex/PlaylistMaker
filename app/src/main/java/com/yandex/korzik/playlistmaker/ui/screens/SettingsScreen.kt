package com.yandex.korzik.playlistmaker.ui.screens

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.net.toUri
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yandex.korzik.playlistmaker.R
import com.yandex.korzik.playlistmaker.data.SettingsMenuUiState
import com.yandex.korzik.playlistmaker.model.UiEvent
import com.yandex.korzik.playlistmaker.ui.components.ColumnSettingsMenu
import com.yandex.korzik.playlistmaker.ui.components.PlaylistMakerTopAppBar
import com.yandex.korzik.playlistmaker.ui.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = viewModel()
) {

    val context: Context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        viewModel.events.collect { event: UiEvent ->
            when (event) {
                is UiEvent.OpenShare -> {
                    val intent: Intent = Intent(Intent.ACTION_SEND).apply {
                        putExtra(Intent.EXTRA_TEXT, context.getString(event.textRes))
                        type = "text/plain"
                    }
                    context.startActivity(Intent.createChooser(intent, null))
                }

                is UiEvent.OpenMail -> {
                    val intent: Intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = "mailto:".toUri()
                        putExtra(Intent.EXTRA_EMAIL, arrayOf(context.getString(event.emailRes)))
                        putExtra(Intent.EXTRA_SUBJECT, context.getString(event.subjectRes))
                        putExtra(Intent.EXTRA_TEXT, context.getString(event.bodyRes))
                    }
                    context.startActivity(intent)
                }

                is UiEvent.OpenUrl -> {
                    val intent = Intent(Intent.ACTION_VIEW, context.getString(event.urlRes).toUri())
                    context.startActivity(intent)
                }
            }
        }
    }

    val settingsMenuUiState: SettingsMenuUiState by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            PlaylistMakerTopAppBar(
                title = R.string.settings,
                colorTopBar = MaterialTheme.colorScheme.background,
                colorTitle = MaterialTheme.colorScheme.onBackground,
                canNavigateBack = true,
                navigateUp = {
                    navController.navigateUp()
                }
            )
        },
        modifier = modifier
    )
    { innerPadding: PaddingValues ->
        ColumnSettingsMenu(
            settingsItemsList = settingsMenuUiState.menu,
            onToggleChange = { id: String, checked: Boolean ->
                viewModel.onToggleChanged(id, checked)
            },
            onActionClick = { id: String ->
                viewModel.onActionClicked(id)
            },
            modifier = Modifier.padding(
                paddingValues = innerPadding
            )
        )
    }
}

@Preview(showSystemUi = true, showBackground = true, locale = "ru")
@Composable
fun SettingsScreenPreview() {
    SettingsScreen(navController = rememberNavController(), modifier = Modifier)
}