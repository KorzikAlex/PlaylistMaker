package com.yandex.korzik.playlistmaker.ui.components

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.yandex.korzik.playlistmaker.R

@OptIn(markerClass = [ExperimentalMaterial3Api::class])
@Composable
fun PlaylistMakerTopAppBar(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    canNavigateBack: Boolean = false,
    navigateUp: () -> Unit = {},
    colorTopBar: Color = MaterialTheme.colorScheme.background,
    colorTitle: Color = contentColorFor(backgroundColor = colorTopBar)
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = title),
                modifier = Modifier
            )
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back)
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorTopBar,
            titleContentColor = colorTitle
        ),
        modifier = modifier
    )
}