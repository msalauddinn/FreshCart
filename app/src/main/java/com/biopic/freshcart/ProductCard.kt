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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AddShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.biopic.freshcart.ui.theme.Black
import com.biopic.freshcart.ui.theme.ForestGreen
import com.biopic.freshcart.ui.theme.Goldenrod
import com.biopic.freshcart.ui.theme.Gray30
import com.biopic.freshcart.ui.theme.Grey
import com.biopic.freshcart.ui.theme.GreyWhite
import com.biopic.freshcart.ui.theme.Red
import com.biopic.freshcart.ui.theme.White

@Composable
fun ProductCard(navController: NavController, product : Product, currentScreen : MutableState<String>) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(end = 8.dp, top = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = White,
            contentColor = Black
        ),
        border = BorderStroke(1.dp, Grey),
        shape = RoundedCornerShape(10.dp),
        onClick = {

        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = White,
                        contentColor = Black
                    ),
                    border = BorderStroke(1.dp, Gray30),
                    shape = RoundedCornerShape(7.dp),
                    content = {
                        Box(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally),
                            content = {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        painter = painterResource(product.image),
                                        contentDescription = "Product",
                                        modifier = Modifier.size(132.dp, 132.dp),
                                        contentScale = ContentScale.Fit,
                                        alignment = Alignment.Center,
                                    )
                                }
                                Row(
                                    modifier = Modifier
                                        .align(Alignment.BottomStart)
                                        .padding(start = 8.dp)
                                        .width(36.dp)
                                        .background(color = White),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = "${product.rating}",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.SemiBold,
                                    )
                                    Icon(
                                        imageVector = Icons.Filled.Star,
                                        contentDescription = "Rating Star",
                                        tint = ForestGreen,
                                        modifier = Modifier
                                            .size(12.dp, 12.dp)
                                    )
                                }
                            }
                        )
                    }
                )
                Text(
                    text = "Quantity : ${product.unit}",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = product.name,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = product.smallDescription,
                    fontSize = 13.sp,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 16.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowDownward,
                        contentDescription = "ArrowDown",
                        tint = ForestGreen,
                        modifier = Modifier.size(20.dp, 20.dp)
                    )
                    Text(
                        text = "${product.discount}%",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = ForestGreen
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "₹${product.mrp}",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        textDecoration = TextDecoration.LineThrough,
                        color = GreyWhite
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "₹${product.originalPrice}",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                if (product.stock > 0) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 32.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier
                                .width(100.dp)
                                .clip(
                                    shape = RoundedCornerShape(50)
                                )
                                .border(
                                    BorderStroke(1.dp, Goldenrod),
                                    shape = RoundedCornerShape(50)
                                ),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            IconButton(
                                modifier = Modifier
                                    .size(32.dp, 24.dp),
                                onClick = {
                                    if (product.itemCount > 1) --product.itemCount
                                }
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.minus),
                                    contentDescription = "Minus",
                                    modifier = Modifier.size(16.dp, 16.dp)
                                )
                            }
                            Text(
                                text = "${product.itemCount}",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.Center
                            )
                            IconButton(
                                modifier = Modifier
                                    .size(32.dp, 24.dp),
                                onClick = {
                                    if (product.itemCount < 10 ) ++product.itemCount
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Add,
                                    contentDescription = "Add",
                                    tint = Black,
                                    modifier = Modifier.size(16.dp, 16.dp)
                                )
                            }
                        }
                        IconButton(
                            onClick = {
                                if (!product.isAddedCart) {
                                    if (product.stock >= product.itemCount) {
                                        product.isAddedCart = true
                                        product.stock -= product.itemCount
                                    }
                                    else {
                                        Toast.makeText(context, "Only ${product.stock} ${product.name} remains",
                                            Toast.LENGTH_SHORT).show()
                                    }
                                }
                                else {
                                    currentScreen.value = "CART"
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.AddShoppingCart,
                                contentDescription = "Add Cart",
                                modifier = Modifier.size(24.dp, 24.dp),
                                tint = if (!product.isAddedCart) Black else ForestGreen
                            )
                        }
                    }
                }
                else {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(R.string.out_of_stock),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Red
                        )
                    }
                }
            }
        }
    )
}