package com.biopic.freshcart

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.biopic.freshcart.ui.theme.Black
import com.biopic.freshcart.ui.theme.ForestGreen
import com.biopic.freshcart.ui.theme.Gray30
import com.biopic.freshcart.ui.theme.Grey
import com.biopic.freshcart.ui.theme.White

@Composable
fun ProductCard(navController : NavController, productList : SnapshotStateList<Product>, paddingValues : PaddingValues) {
    val searchText = remember {
        mutableStateOf("")
    }
    val isSearchClicked = remember {
        mutableStateOf(false)
    }
    val filterProductList = productList.filter { product ->
        product.name.contains(searchText.value, ignoreCase = true)
    }

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(color = White)
            .pointerInput(Unit) {
                detectTapGestures {
                    focusManager.clearFocus()
                }
            }
    ) {
        OutlinedTextField(
            value = searchText.value,
            onValueChange = { text ->
                searchText.value = text
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = White,
                unfocusedContainerColor = White,

                focusedTextColor = Black,
                unfocusedTextColor = Black,

                focusedIndicatorColor = Grey,
                unfocusedIndicatorColor = Grey
            ),
            shape = RoundedCornerShape(50),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Search",
                    tint = if (isSearchClicked.value) Black else Grey
                )
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.search_placeHolder),
                    color = Grey
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, top = 12.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = { focusManager.clearFocus() }
            )
        )
        LazyVerticalGrid(
            modifier = Modifier.padding(start = 8.dp),
            columns = GridCells.Adaptive(212.dp),
        ) {
            items(
                count = filterProductList.count(),
                itemContent = { index ->
                    val product = productList[index]
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
                            Column {
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp),
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
                                                    modifier = Modifier.align(Alignment.BottomStart).padding(start = 8.dp),
                                                    verticalAlignment = Alignment.CenterVertically
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
                            }
                        }
                    )
                }
            )
        }
    }
}