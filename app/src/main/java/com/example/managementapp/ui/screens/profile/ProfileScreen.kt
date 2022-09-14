package com.example.managementapp.ui.screens.profile

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.managementapp.R
import com.example.managementapp.ui.screens.appbar.CenterTopAppBar
import com.example.managementapp.ui.screens.appbar.components.ActionComponent
import com.example.managementapp.ui.screens.appbar.components.modifierComponent
import com.example.managementapp.ui.screens.appbar.components.NavigationIconComponent
import com.example.managementapp.ui.screens.appbar.components.TitleComponent
import com.example.managementapp.ui.screens.drawer.NavigationDrawer
import com.example.managementapp.ui.theme.ManagementAppTheme
import com.example.managementapp.ui.theme.backgroundWhite
import com.example.managementapp.ui.theme.profileAccentRed
import com.example.managementapp.ui.theme.profileBorderBackground
import com.example.managementapp.ui.utils.BackHandler
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(navController: NavController) {
    ManagementAppTheme {
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
                    CenterTopAppBar(
                        backgroundColor = Color.Transparent,
                        contentColor = Color.White,
                        elevation = 0.dp,
                        modifier = modifierComponent(),
                        navigationIcon = {
                            NavigationIconComponent(
                                scaffoldState = scaffoldState,
                                scopeState = scopeState
                            )
                        },
                        title = { TitleComponent(icon = R.drawable.ic_profile) },
                        actions = {
                            ActionComponent(
                                icon = R.drawable.ic_back_arrow,
                                onClick = { navController.popBackStack() })
                        }
                    )
                }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 10.dp, start = 10.dp)
                        .border(
                            (0.5).dp,
                            profileBorderBackground,
                            RoundedCornerShape(topStart = 12.dp)
                        )
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(topStart = 12.dp),
                        ),
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_profileimage),
                            contentDescription = "",
                            modifier = Modifier.padding(top = 10.dp, start = 10.dp)
                        )
                        Box(
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.fillMaxSize()) {
                                Box(modifier = Modifier.fillMaxWidth()) {
                                    Row(modifier = Modifier.fillMaxWidth()) {
                                        Text(
                                            text = "Черный Виталий Михайлович",
                                            modifier = Modifier.padding(top = 10.dp, end = 60.dp),
                                            fontSize = 20.sp,
                                            fontFamily = FontFamily(Font(R.font.roboto_regular))
                                        )
                                    }
                                    Row(
                                        horizontalArrangement = Arrangement.End,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_bookmark),
                                            contentDescription = "",
                                            modifier = Modifier.padding(end = 10.dp)
                                        )
                                    }
                                }
                                Box(modifier = Modifier.fillMaxWidth()) {
                                    Column() {

                                        Row() {
                                            Text(
                                                text = "id: ",
                                                fontSize = 10.sp,
                                                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                                color = backgroundWhite
                                            )
                                            Text(
                                                text = "19986423",
                                                fontSize = 10.sp,
                                                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                                color = Color.Black
                                            )
                                        }
                                        Row() {
                                            Text(
                                                text = "Организация: ",
                                                fontSize = 10.sp,
                                                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                                color = backgroundWhite,
                                                modifier = Modifier
                                                    .offset(0.dp, 4.dp)
                                                    .blur(4.dp)
                                            )
                                            Text(
                                                text = "AiweApps",
                                                fontSize = 10.sp,
                                                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                                color = Color.Black,
                                                modifier = Modifier
                                                    .offset(0.dp, 4.dp)
                                                    .blur(4.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Column(modifier = Modifier.padding(top = 320.dp)) {

                        ProfileButton(
                            backgroundColor = backgroundWhite,
                            contentColor = Color.Black,
                            text = "Настройки",
                            icon = R.drawable.ic_settings
                        ) {}
                        Spacer(modifier = Modifier.height(20.dp))
                        ProfileButton(
                            backgroundColor = backgroundWhite,
                            contentColor = Color.Black,
                            text = "Обратная связь",
                            icon = R.drawable.ic_bx_message_dots
                        ) {}
                        Spacer(modifier = Modifier.height(20.dp))
                        ProfileButton(
                            backgroundColor = profileAccentRed,
                            contentColor = backgroundWhite,
                            text = "Выйти",
                            icon = R.drawable.ic_logout
                        ) {}
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileButton(
    backgroundColor: Color,
    contentColor: Color,
    text: String,
    @DrawableRes icon: Int,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick.invoke() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(start = 10.dp, end = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.weight(1F),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = text,
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "",
                modifier = Modifier
                    .height(25.dp)
                    .width(25.dp)
            )
        }
    }
}
