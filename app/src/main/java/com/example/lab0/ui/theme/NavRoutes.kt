package com.example.lab0.ui.theme

sealed class NavRoutes(val route: String) {
    object Login : NavRoutes("login")
    object List : NavRoutes("list")
    object Detail : NavRoutes("detail")
}