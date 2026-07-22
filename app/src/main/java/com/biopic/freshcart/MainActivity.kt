package com.biopic.freshcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
    val context = LocalContext.current
    val session = readSessionData(context)
    val productList = rememberProducts()

    NavHost(
        navController = navController,
        startDestination = if (session.isLoggedIn) Screen.MAINSCREEN else Screen.LOGIN
    ) {
        composable(route = Screen.LOGIN) {
            LogInScreen(navController)
        }
        composable(route = Screen.SIGNUP) {
            SignUpScreen(navController)
        }
        composable(route = Screen.FORGOTPASSWORD) {
            ForgotPasswordScreen()
        }
        composable(route = Screen.MAINSCREEN) {
            MainScreen(navController, productList)
        }
        composable (
            route = "${Screen.PRODUCT_DETAILS}/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("id")
            productId?.let { id ->
                ProductDetails(navController,productList, id)
            }
        }
    }
}