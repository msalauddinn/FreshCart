package com.biopic.freshcart

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.biopic.freshcart.ui.theme.Black
import com.biopic.freshcart.ui.theme.DodgerBlue
import com.biopic.freshcart.ui.theme.Gray30
import com.biopic.freshcart.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController, name : String) {
    val currentScreen = remember {
        mutableStateOf("HOME")
    }
    val productList = rememberProducts()
    val topBarBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    val isHome = currentScreen.value == "HOME"
    val isCategory = currentScreen.value == "CATEGORY"
    val isAccount = currentScreen.value == "ACCOUNT"
    val isCart = currentScreen.value == "CART"
    val iconSize = 36.dp

    Scaffold(
        modifier = Modifier.nestedScroll(topBarBehavior.nestedScrollConnection),
        topBar = {
            when (currentScreen.value) {
                "HOME" -> {
                    HomeScreen(name, topBarBehavior)
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                containerColor = White,
                modifier = Modifier
                    .border(1.dp, Gray30, shape = RoundedCornerShape(10))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton(
                        onClick = {
                            currentScreen.value = "HOME"
                        }
                    ) {
                        Icon(
                            imageVector = if (isHome) Icons.Filled.Home else Icons.Outlined.Home,
                            contentDescription = "Home",
                            tint = if (isHome) DodgerBlue else Black,
                            modifier = Modifier
                                .size(iconSize, iconSize)
                        )
                    }
                    IconButton(
                        onClick = {
                            currentScreen.value = "CATEGORY"
                        }
                    ) {
                        Icon(
                            imageVector = if (isCategory) Icons.Filled.Category else Icons.Outlined.Category,
                            contentDescription = "Category",
                            tint = if (isCategory) DodgerBlue else Black,
                            modifier = Modifier
                                .size(iconSize, iconSize)
                        )
                    }
                    IconButton(
                        onClick = {
                            currentScreen.value = "ACCOUNT"
                        }
                    ) {
                        Icon(
                            imageVector = if (isAccount) Icons.Filled.Person else Icons.Outlined.Person,
                            contentDescription = "Account",
                            tint = if (isAccount) DodgerBlue else Black,
                            modifier = Modifier
                                .size(iconSize, iconSize)
                        )
                    }
                    IconButton(
                        onClick = {
                            currentScreen.value = "CART"
                        }
                    ) {
                        Icon(
                            imageVector = if (isCart) Icons.Filled.ShoppingCart else Icons.Outlined.ShoppingCart,
                            contentDescription = "Cart",
                            tint = if (isCart) DodgerBlue else Black,
                            modifier = Modifier
                                .size(iconSize, iconSize)
                        )
                    }
                }
            }
        },
        content = { paddingValues ->
            if (isHome) ProductCard(navController, productList, paddingValues)
        }
    )
}