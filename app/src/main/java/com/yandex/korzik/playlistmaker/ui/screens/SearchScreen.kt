package com.yandex.korzik.playlistmaker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yandex.korzik.playlistmaker.R
import com.yandex.korzik.playlistmaker.data.dto.SearchUiState
import com.yandex.korzik.playlistmaker.ui.components.PlaylistMakerTopAppBar
import com.yandex.korzik.playlistmaker.ui.components.SearchTextField
import com.yandex.korzik.playlistmaker.ui.viewmodel.SearchViewModel

@Composable
fun SearchScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = viewModel()
) {
    val searchUiState: SearchUiState by viewModel.uiState.collectAsState()

    val focusRequester: FocusRequester = remember {
        FocusRequester()
    }
    val keyboardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
        keyboardController?.show()
    }

    Scaffold(
        topBar = {
            PlaylistMakerTopAppBar(
                title = R.string.app_name,
                colorTopBar = MaterialTheme.colorScheme.background,
                canNavigateBack = true,
                navigateUp = {
                    navController.navigateUp()
                }
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding: PaddingValues ->
        Column(modifier = Modifier.padding(paddingValues = innerPadding)) {
            SearchTextField(
                searchText = searchUiState.searchText,
                onSearchTextChange = {
                    viewModel.onSearchTextChanged(it)
                },
                onClearClick = {
                    viewModel.onClearClick()
                },
                modifier = Modifier
                    .padding(all = dimensionResource(R.dimen.padding_medium))
                    .fillMaxWidth()
                    .focusRequester(focusRequester)
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true, locale = "ru", name = "RussianPreview")
@Composable
fun SearchScreenPreview() {
    SearchScreen(navController = rememberNavController())
}