package com.yandex.korzik.playlistmaker

import android.content.Context
import android.os.Bundle
import android.view.Surface
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.yandex.korzik.playlistmaker.data.Datasource
import com.yandex.korzik.playlistmaker.model.MainMenuItem
import com.yandex.korzik.playlistmaker.ui.navigation.AppNavGraph
import com.yandex.korzik.playlistmaker.ui.theme.PlaylistMakerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaylistMakerTheme {
                val navController = rememberNavController()
                AppNavGraph(navController = navController)
            }
        }
    }
}

//@Composable
//fun PlayListMakerApp(modifier: Modifier = Modifier) {
//    PlaylistMakerTheme {
//        Scaffold(
//            topBar = {
//                PlayListMakerTopAppBar(title = R.string.app_name)
//            },
//            modifier = modifier
//        ) { innerPadding ->
//            ColumnMainMenu(
//                mainMenuItemsList = Datasource().loadMenuItems(),
//                modifier = Modifier.padding(paddingValues = innerPadding)
//            )
//        }
//    }
//}

//@Composable
//fun ColumnMainMenu(mainMenuItemsList: List<MainMenuItem>, modifier: Modifier = Modifier) {
//    Surface(modifier = modifier, shape = RoundedCornerShape(16.dp, 16.dp)) {
//        LazyColumn(
//            modifier = Modifier.fillMaxWidth(),
//            verticalArrangement = Arrangement.SpaceBetween
//        ) {
//            items(items = mainMenuItemsList) { menuItem ->
//                MainMenuItem(
//                    icon = menuItem.iconResourceId,
//                    text = menuItem.stringResourceId,
//                    modifier = Modifier
//                )
//            }
//        }
//    }
//}

//@Composable
//fun MainMenuItem(
//    @DrawableRes icon: Int,
//    @StringRes text: Int,
//    modifier: Modifier,
//    @StringRes contentDescription: Int? = null,
//) {
//    val contentDescription: String? = contentDescription?.let { stringResource(id = it) }
//    Row(
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(all = dimensionResource(id = R.dimen.padding_small)),
//        horizontalArrangement = Arrangement.spacedBy(
//            space = dimensionResource(id = R.dimen.padding_small),
//            Alignment.Start
//        ),
//        verticalAlignment = Alignment.CenterVertically,
//    ) {
//        Icon(
//            painter = painterResource(id = icon),
//            contentDescription = contentDescription,
//            modifier = Modifier
//        )
//        Text(
//            text = stringResource(text),
//            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
//            modifier = Modifier,
//        )
//        Spacer(modifier = Modifier.weight(1f))
//        IconButton(onClick = {}, modifier = Modifier) {
//            Icon(
//                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
//                contentDescription = null
//            )
//        }
//    }
//}
//
//fun displayToast(
//    context: Context,
//    text: String,
//    duration: Int = Toast.LENGTH_LONG
//) {
//    Toast.makeText(
//        context,
//        text,
//        duration
//    ).show()
//}
//
//
//@Preview(
//    showBackground = true,
//    showSystemUi = true,
//    locale = "ru",
//    name = "russian_locale_system_ui"
//)
//@Composable
//fun PlayListMakerPreview() {
//    PlayListMakerApp()
//}