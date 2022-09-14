package com.example.managementapp.ui.screens.management

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.managementapp.BoxRow
import com.example.managementapp.R
import com.example.managementapp.boxpaddings
import com.example.managementapp.ui.screens.drawer.NavigationDrawer
import com.example.managementapp.ui.theme.ManagementAppTheme
import com.example.managementapp.ui.theme.topAppBarGradientBottom
import com.example.managementapp.ui.theme.topAppBarGradientTop
import com.example.managementapp.ui.utils.*
import kotlinx.coroutines.launch


@Composable
fun ManagementScreen(
    navController: NavController
) {
    ManagementAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val scaffoldState = rememberScaffoldState()
            val scopeState = rememberCoroutineScope()
            if (scaffoldState.drawerState.isOpen)
                BackHandler(onBack = { scopeState.launch { scaffoldState.drawerState.close() } })
            Scaffold(
                scaffoldState = scaffoldState,
                drawerContent = {
                    NavigationDrawer(navController) {
                        scopeState.launch {
                            scaffoldState.drawerState.close()
                        }
                    }
                },
                topBar = {
                    TopAppBar(
                        backgroundColor = Color.Transparent,
                        contentColor = Color.White,
                        elevation = 0.dp,
                        modifier = Modifier
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(topAppBarGradientTop, topAppBarGradientBottom),
                                )
                            ),

                        title = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center,
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_meteor),
                                        contentDescription = ""
                                    )
                                    Spacer(modifier = Modifier.width(56.dp))
                                }
                            }
                        },
                        navigationIcon = {
                            IconButton(onClick = {
                                scopeState.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_menu),
                                    contentDescription = ""
                                )
                            }
                        })
                }) {
                Column {
                    BoxRow {
                        ManagementTile(appMainAction = AppMainActions.ARCHIVE, size = TileSize.BIG) {
                            navController.navigateLaunchSingleTop(ScreenRoutes.ProfileScreenRoute.route)
                        }
                        ManagementTile(appMainAction = AppMainActions.REPORT, size = TileSize.BIG) {}
                    }

                    BoxRow {
                        ManagementTile(
                            appMainAction = AppMainActions.ARCHIVE_ADD,
                            size = TileSize.BIG
                        ) {}
                        ManagementTile(appMainAction = AppMainActions.SEARCH, size = TileSize.BIG) {}
                    }

                    BoxRow {
                        ManagementTile(
                            appMainAction = AppMainActions.EXPENSES,
                            size = TileSize.SMALL
                        ) {}
                        ManagementTile(appMainAction = AppMainActions.QRCODE, size = TileSize.SMALL) {}
                        ManagementTile(
                            appMainAction = AppMainActions.FEEDBACK,
                            size = TileSize.SMALL
                        ) {}
                        ManagementTile(
                            appMainAction = AppMainActions.REFERENCE,
                            size = TileSize.SMALL
                        ) {}
                    }
                }
            }
        }
    }
}

@Composable
fun ManagementTile(
    appMainAction: AppMainActions,
    size: TileSize,
    onClick: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val boxImage: Int = appMainAction.image
    val description: String = appMainAction.actionName

    val modifier = when (size) {
        TileSize.BIG -> Modifier
            .width(screenWidth / 2 - boxpaddings)
            .height(110.dp)
            .clickable { onClick.invoke() }
        TileSize.SMALL -> Modifier
            .width(screenWidth / 4 - boxpaddings)
            .height(75.dp)
            .clickable { onClick.invoke() }
    }

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(5.dp),
        elevation = 4.dp,
        backgroundColor = Color(0, 85, 145)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val image = painterResource(id = boxImage)
            Image(painter = image, contentDescription = "")
            if (size == TileSize.BIG)
                Text(text = description, color = Color.White)
        }
    }
}