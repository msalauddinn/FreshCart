package com.biopic.freshcart

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biopic.freshcart.ui.theme.Black
import com.biopic.freshcart.ui.theme.Gray30
import com.biopic.freshcart.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(name: String, topBarBehavior: TopAppBarScrollBehavior) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.welcome),
                    fontSize = 16.sp
                )
                Text(
                    text = " $name",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = White,
            titleContentColor = Black,
            scrolledContainerColor = White,
        ),
        modifier = Modifier
            .border(1.dp, Gray30),
        scrollBehavior = topBarBehavior
    )
}