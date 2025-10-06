package com.yandex.korzik.playlistmaker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.yandex.korzik.playlistmaker.R
import com.yandex.korzik.playlistmaker.ui.components.PlaylistMakerTopAppBar
import com.yandex.korzik.playlistmaker.ui.components.SearchTextField

@Composable
fun SearchScreen(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            PlaylistMakerTopAppBar(
                title = R.string.app_name,
                colorTopBar = MaterialTheme.colorScheme.background,
                colorTitle = Color.Black
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Column(modifier = Modifier.padding(paddingValues = innerPadding)) {
            SearchTextField(
                modifier = Modifier
                    .padding(all = dimensionResource(R.dimen.padding_medium))
                    .fillMaxWidth()
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true, locale = "ru", name = "RussianPreview")
@Composable
fun SearchScreenPreview() {
    SearchScreen(navController = NavController(context = LocalContext.current))
}