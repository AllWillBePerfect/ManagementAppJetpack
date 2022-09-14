package com.example.managementapp.ui.screens.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.managementapp.R
import com.example.managementapp.ui.theme.backgroundWhite
import com.example.managementapp.ui.utils.AppMainActions
import com.example.managementapp.ui.theme.navigationDrawerColor
import com.example.managementapp.ui.theme.topAppBarGradientBottom
import com.example.managementapp.ui.theme.topAppBarGradientTop
import com.example.managementapp.ui.utils.ScreenRoutes
import com.example.managementapp.ui.utils.navigateLaunchSingleTop

@Composable
fun NavigationDrawer(navController: NavController, closeDrawer: () -> Unit) {
    Box(
        modifier = Modifier
            .background(color = backgroundWhite)
            .fillMaxSize()
    ) {
        Column {
            NavigationDrawerTopBar()
            NavigationDrawerContent(navController, closeDrawer)
        }
    }
}

@Composable
private fun NavigationDrawerTopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(topAppBarGradientTop, topAppBarGradientBottom),
                )
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {

            Spacer(modifier = Modifier.width(15.dp))
            Icon(
                painter = painterResource(id = R.drawable.box_logo_small), contentDescription = "",
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "InventApp",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.roboto_regular))
            )
        }
    }
}

@Composable
private fun NavigationDrawerContent(navController: NavController, closeDrawer: () -> Unit) {
    Spacer(modifier = Modifier.height(40.dp))
    NavigationDrawerItem(item = AppMainActions.HOME) {}
    NavigationDrawerDivider()
    NavigationDrawerItem(item = AppMainActions.ARCHIVE) {}
    NavigationDrawerItem(item = AppMainActions.REPORT) {}
    NavigationDrawerItem(item = AppMainActions.EXPENSES) {}
    NavigationDrawerItem(item = AppMainActions.SEARCH) {}
    NavigationDrawerDivider()
    NavigationDrawerItem(item = AppMainActions.PROFILE) {
        navController.navigateLaunchSingleTop(ScreenRoutes.ProfileScreenRoute.route)
        closeDrawer.invoke()
    }
    NavigationDrawerItem(item = AppMainActions.FEEDBACK) {}
    NavigationDrawerDivider()
    NavigationDrawerItem(item = AppMainActions.SETTINGS) {}
}

@Composable
private fun NavigationDrawerItem(
    item: AppMainActions,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(start = 30.dp)
            .clickable { onClick.invoke() }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = item.image),
                contentDescription = "",
                tint = navigationDrawerColor,
                modifier = Modifier
                    .height(32.dp)
                    .width(32.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = item.actionName,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                color = navigationDrawerColor
            )
        }
    }
    Spacer(modifier = Modifier.height(14.dp))
}

@Composable
private fun NavigationDrawerDivider() {
    Divider(
        color = navigationDrawerColor,
        modifier = Modifier
            .fillMaxWidth(),
        thickness = (1.5).dp,
    )
    Spacer(modifier = Modifier.height(14.dp))
}
