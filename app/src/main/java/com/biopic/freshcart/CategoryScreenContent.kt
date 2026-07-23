package com.biopic.freshcart

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.biopic.freshcart.ui.theme.Black
import com.biopic.freshcart.ui.theme.Gray30
import com.biopic.freshcart.ui.theme.GreyWhite
import com.biopic.freshcart.ui.theme.White

@Composable
fun CategoryScreenContent(
    navController: NavController,
    productList: SnapshotStateList<Product>,
    paddingValues: PaddingValues
) {

    // All categories list
    val categoryList = productList.map { product ->
        product.category
    }.distinct()

    // Showing category name
    LazyVerticalGrid(
        modifier = Modifier
            .padding(paddingValues)
            .background(color = White),
        columns = GridCells.Adaptive(212.dp),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 12.dp)
    ) {
        items(
            count = categoryList.count(),
            itemContent = { index ->
                val category = categoryList[index]
                // Outside Card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp, bottom = 8.dp),
                    border = BorderStroke(1.dp, Gray30),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = White,
                        contentColor = Black
                    ),
                    onClick = {
                        navController.navigate(route = "${Screen.CATEGORY_PRODUCT_SCREEN}/${category}")
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Image Card
                        Card(
                            modifier = Modifier.padding(vertical = 8.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = White,
                                contentColor = Black
                            ),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, Gray30)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Category,
                                contentDescription = "Category Image",
                                tint = GreyWhite,
                                modifier = Modifier
                                    .size(160.dp, 160.dp)
                            )
                        }
                        // Category name
                        Text(
                            text = category,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp
                        )
                    }
                }
            }
        )
    }
}