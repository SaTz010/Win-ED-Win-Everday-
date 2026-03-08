package com.example.wined.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.wined.screens.*

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        composable("login") {
            LoginScreen(navController)
        }

        composable("signup") {
            SignupScreen(navController)
        }

        composable("home") {
            HomeScreen(navController)
        }

        composable("progress") {
            ProgressScreen(navController)
        }

        composable("profile") {
            ProfileScreen(navController)
        }

        composable("settings") {
            SettingsScreen(navController)
        }
    }
}
