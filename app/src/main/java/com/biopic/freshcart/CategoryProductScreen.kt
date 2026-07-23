package com.biopic.freshcart

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.biopic.freshcart.ui.theme.Black
import com.biopic.freshcart.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryProductScreen(
    navController: NavController,
    category : String,
    productList: SnapshotStateList<Product>,
    currentScreen: MutableState<String>,
    user : User
) {
    val topAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val categoryProducts = productList.filter { product ->
        product.category.contains(category)
    }
    val categoryProductList = categoryProducts.toMutableStateList()

    Scaffold(
        containerColor = White,
        modifier = Modifier.nestedScroll(topAppBarScrollBehavior.nestedScrollConnection),
        topBar = {
            // Top Bar of each Category Products
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = White,
                    scrolledContainerColor = White,
                    titleContentColor = Black,
                ),
                scrollBehavior = topAppBarScrollBehavior,
                navigationIcon = {
                    // Arrow Back Icon
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back Arrow",
                            modifier = Modifier
                                .size(32.dp,32.dp),
                            tint = Black
                        )
                    }
                },
                title = {
                    Text(
                        text = category,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(start = 12.dp)
                    )
                }
            )
        },
        content = { paddingValues ->
            // Content of this page, Reuse of HomeScreenContent
            HomeScreenContent(navController, productList = categoryProductList, paddingValues, currentScreen, user)
        }
    )
}