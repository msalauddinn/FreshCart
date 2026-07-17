package com.biopic.freshcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.biopic.freshcart.ui.theme.FreshCartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FreshCartTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    MainPage()
                }
            }
        }
    }
}

@Composable
fun MainPage() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "LogInScreen"
    ) {
        composable(route = "LogInScreen") {
            LogInScreen(navController)
        }
        composable(route = "SignUpScreen") {
            SignUpScreen(navController)
        }
        composable(route = "ForgotPasswordScreen") {
            ForgotPasswordScreen()
        }
    }
}