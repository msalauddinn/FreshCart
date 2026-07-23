package com.biopic.freshcart

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.biopic.freshcart.ui.theme.Black
import com.biopic.freshcart.ui.theme.ButtonColor
import com.biopic.freshcart.ui.theme.ForestGreen
import com.biopic.freshcart.ui.theme.Gray30
import com.biopic.freshcart.ui.theme.GreyWhite
import com.biopic.freshcart.ui.theme.Red
import com.biopic.freshcart.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetails(navController: NavController, productList: SnapshotStateList<Product>, id: Int, user : User) {
    // which product is clicked
    val selectedProduct = productList.find { product ->
        product.id == id
    }
    val context = LocalContext.current

    // if selected product is not null
    if (selectedProduct != null) {
        Scaffold(
            // Top Bar of Product Details page
            topBar = {
                TopAppBar(
                    modifier = Modifier.border(1.dp, Gray30),
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = White,
                        titleContentColor = Black,

                        navigationIconContentColor = Black
                    ),
                    // Arrow Back Icon
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navController.popBackStack()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Arrow Back",
                                modifier = Modifier
                                    .size(36.dp, 36.dp)
                            )
                        }
                    },
                    // Title
                    title = {
                        Text(
                            text = stringResource(R.string.product_details),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                )
            },
            // Bottom Bar or Bottom Buttons
            bottomBar = {
                BottomAppBar(
                    containerColor = White,
                    contentColor = Black,
                    modifier = Modifier
                        .border(1.dp, Gray30)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Add to cart or Go to cart Button
                        Button(
                            onClick = {

                            },
                            modifier = Modifier
                                .size(152.dp, 48.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = White,
                                contentColor = Black
                            ),
                            shape = RoundedCornerShape(10.dp),
                            border = BorderStroke(1.dp, Gray30)
                        ) {
                            Text(
                                text = if (selectedProduct.isAddedCart) stringResource(R.string.go_cart) else stringResource(
                                    R.string.add_cart
                                ),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        }
                        // Buy button
                        Button(
                            onClick = {

                            },
                            modifier = Modifier
                                .size(152.dp, 48.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = ButtonColor,
                                contentColor = Black
                            ),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(
                                text = "${stringResource(R.string.buy)} ₹${selectedProduct.originalPrice}",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(White)
                        .padding(paddingValues)
                        .verticalScroll(rememberScrollState())
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 28.dp, start = 54.dp, end = 54.dp)
                    ) {
                        // Image Box
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(332.dp, 332.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .border(1.dp, Black, RoundedCornerShape(10.dp)),
                            content = {
                                // Product Image
                                Image(
                                    painter = painterResource(selectedProduct.image),
                                    contentDescription = selectedProduct.name,
                                    modifier = Modifier
                                        .size(300.dp, 300.dp)
                                        .align(Alignment.Center),
                                    contentScale = ContentScale.Fit,
                                    alignment = Alignment.Center
                                )
                                // Favorite Icon
                                IconButton(
                                    onClick = {
                                        // if favorite is true then click again make unFavorite and if false then make favorite
                                        selectedProduct.isFavorite = !selectedProduct.isFavorite
                                        // if selected product is favorite then add and store at the local file
                                        if (selectedProduct.isFavorite) {
                                            user.favoriteProducts.add(selectedProduct.id)
                                        }
                                        // if not then remove from list and store at the local file
                                        else {
                                            user.favoriteProducts.remove(selectedProduct.id)
                                        }
                                        writeData(user, context)
                                    },
                                    modifier = Modifier.align(Alignment.TopEnd)
                                ) {
                                    Icon(
                                        imageVector = if (selectedProduct.isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                                        contentDescription = "Favorite",
                                        tint = if (selectedProduct.isFavorite) Red else Black,
                                        modifier = Modifier
                                            .size(36.dp, 36.dp)
                                            .padding(end = 12.dp, top = 12.dp)
                                    )
                                }
                                // Rating Text
                                Row(
                                    modifier = Modifier
                                        .width(60.dp)
                                        .background(color = White)
                                        .padding(start = 20.dp, bottom = 12.dp)
                                        .align(Alignment.BottomStart),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "${selectedProduct.rating}",
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Black
                                    )
                                    Icon(
                                        imageVector = Icons.Filled.Star,
                                        contentDescription = "Rating Star",
                                        tint = ForestGreen,
                                        modifier = Modifier
                                            .size(16.dp, 16.dp)
                                    )
                                }
                            }
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        // Quantity of product
                        Text(
                            text = "${stringResource(R.string.quantity)} : ${selectedProduct.unit}",
                            fontWeight = FontWeight.Medium,
                            color = Black
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        // Product name
                        Text(
                            text = selectedProduct.name,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Black
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        // Product brief description
                        Text(
                            text = selectedProduct.bigDescription,
                            color = Black
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        // Price Text
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Filled.ArrowDownward,
                                contentDescription = "ArrowDown",
                                tint = ForestGreen,
                                modifier = Modifier.size(28.dp, 28.dp)
                            )
                            Text(
                                text = "${selectedProduct.discount}%",
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Bold,
                                color = ForestGreen
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "₹${selectedProduct.mrp}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 19.sp,
                                textDecoration = TextDecoration.LineThrough,
                                color = GreyWhite
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "₹${selectedProduct.originalPrice}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 19.sp,
                                color = Black
                            )
                        }
                    }
                }
            }
        )
    }
    else {
        Toast.makeText(context, "Product is no Longer Exist", Toast.LENGTH_SHORT).show()
    }
}