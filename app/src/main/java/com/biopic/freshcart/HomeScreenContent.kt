package com.biopic.freshcart

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.biopic.freshcart.ui.theme.Black
import com.biopic.freshcart.ui.theme.Grey
import com.biopic.freshcart.ui.theme.White

@Composable
fun HomeScreenContent(navController : NavController, productList : SnapshotStateList<Product>, paddingValues : PaddingValues, currentScreen : MutableState<String>) {
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
    val displayList = if (isSearchClicked.value) filterProductList else productList

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
                unfocusedIndicatorColor = Grey,

                cursorColor = Black
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
                .padding(start = 8.dp, end = 8.dp, top = 12.dp)
                .onFocusChanged{ focusState ->
                    isSearchClicked.value = focusState.isFocused
                },
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
                count = displayList.count(),
                itemContent = { index ->
                    val displayProduct = displayList[index]
                    ProductCard(navController, displayProduct, currentScreen)
                }
            )
        }
    }
}