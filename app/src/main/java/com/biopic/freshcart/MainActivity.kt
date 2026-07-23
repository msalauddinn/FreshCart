package com.biopic.freshcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    val currentScreen = remember {
        mutableStateOf("HOME")
    }
    val navController = rememberNavController()
    val context = LocalContext.current
    val session = readSessionData(context)
    val productList = rememberProducts()
    val user = readData(context)


    NavHost(
        navController = navController,
        startDestination = if (session.isLoggedIn) Screen.MAINSCREEN else Screen.LOGIN
    ) {
        composable(route = Screen.LOGIN) {
            LogInScreen(navController, user)
        }
        composable(route = Screen.SIGNUP) {
            SignUpScreen(navController, user)
        }
        composable(route = Screen.FORGOTPASSWORD) {
            ForgotPasswordScreen()
        }
        composable(route = Screen.MAINSCREEN) {
            MainScreen(navController, productList, currentScreen, user)
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
                ProductDetails(navController,productList, id, user)
            }
        }
        composable(
            route = "${Screen.CATEGORY_PRODUCT_SCREEN}/{category}",
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category")
            category?.let { category ->
                CategoryProductScreen(navController, category, productList, currentScreen, user)
            }

        }
    }
}