package com.example.jetpackapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackapp.ui.screens.AccessDeniedScreen
import com.example.jetpackapp.ui.screens.DetailScreen
import com.example.jetpackapp.ui.screens.WelcomeScreen
import com.example.jetpackapp.ui.theme.JetpackAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackAppTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") {
            WelcomeScreen(
                onNavigateToDetail = { userName ->
                    navController.navigate("detail/$userName")
                },
                onAccessDenied = {
                    navController.navigate("accessDenied")
                }
            )
        }
        composable(
            route = "detail/{userName}",
            arguments = listOf(navArgument("userName") { type = NavType.StringType })
        ) { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName") ?: ""
            DetailScreen(navController = navController, userName = userName)
        }
        composable("accessDenied") {
            AccessDeniedScreen(navController = navController)
        }
    }
}
