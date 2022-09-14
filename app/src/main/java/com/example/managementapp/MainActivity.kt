package com.example.managementapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.managementapp.ui.screens.auth.AuthScreen
import com.example.managementapp.ui.screens.management.ManagementScreen
import com.example.managementapp.ui.screens.profile.ProfileScreen
import com.example.managementapp.ui.utils.ScreenRoutes
import com.example.managementapp.ui.utils.AppMainActions
import com.example.managementapp.ui.utils.GraphRoutes
import com.example.managementapp.ui.utils.TileSize

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val isSigned = App.userRepository.isSigned()
        val startRoute = if (isSigned) GraphRoutes.MainGraphRoute.route else ScreenRoutes.AuthScreenRoute.route

        setContent {
            AppNavigation(viewModel = viewModel, context = this, startRoute = startRoute)
//            AppNavigation(viewModel = viewModel, context = this, startRoute = ScreenRoutes.ProfileScreenRoute.route)
        }
    }
}

@Composable
fun AppNavigation(viewModel: MainViewModel, context: Context, startRoute: String) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startRoute) {
        composable(ScreenRoutes.AuthScreenRoute.route) { AuthScreen(navController) }
        composable(ScreenRoutes.ProfileScreenRoute.route) { ProfileScreen(navController)}

//        composable(ScreenRoutes.ManagementScreenRoute.route) { ManagementScreen() }
        /*navigation(startDestination = ScreenRoutes.AuthScreenRoute.route, route = "auth") {
            composable(ScreenRoutes.AuthScreenRoute.route) { AuthScreen(navController) }
        }*/
        navigation(startDestination = ScreenRoutes.ManagementScreenRoute.route, route = GraphRoutes.MainGraphRoute.route) {
            composable(ScreenRoutes.ManagementScreenRoute.route) { ManagementScreen(navController) }
        }
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startRoute: ScreenRoutes
) {
    NavHost(navController = navController, startDestination = startRoute.route) {
        composable(ScreenRoutes.ManagementScreenRoute.route) {ManagementScreen(navController)}
        composable(ScreenRoutes.AuthScreenRoute.route) { AuthScreen(navController) }
    }
}


@Composable
fun BoxRow(child: @Composable() () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        child.invoke()
    }
}




