package com.biopic.freshcart

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
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
fun TopBar(title : String) {
    // All Screen top bar
    TopAppBar(
        modifier = Modifier
            .border(1.dp, Gray30),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = White,
            titleContentColor = Black,
            scrolledContainerColor = White
        ),
        title = {
            Text(
                text = title,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(start = 28.dp)
            )
        }
    )
}