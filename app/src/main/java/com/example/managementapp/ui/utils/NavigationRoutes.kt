package com.example.managementapp.ui.utils

import androidx.navigation.NavController

sealed class ScreenRoutes(val route: String) {
    object AuthScreenRoute: ScreenRoutes("AuthScreen")
    object ManagementScreenRoute: ScreenRoutes("ManagementScreen")

    object ProfileScreenRoute: ScreenRoutes("ProfileScreen")
}

sealed class GraphRoutes(val route: String) {
    object MainGraphRoute: GraphRoutes("MainGraph")
}

fun NavController.navigateLaunchSingleTop(route: String) {
    this.navigate(route) {launchSingleTop = true}
}
