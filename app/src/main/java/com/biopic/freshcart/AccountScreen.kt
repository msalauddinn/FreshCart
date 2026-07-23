package com.biopic.freshcart

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biopic.freshcart.ui.theme.Black
import com.biopic.freshcart.ui.theme.DodgerBlue
import com.biopic.freshcart.ui.theme.Gray30
import com.biopic.freshcart.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen(title : String) {
    val isHelpClicked = remember {
        mutableStateOf(false)
    }
    TopAppBar(
        modifier = Modifier
            .border(1.dp, Gray30),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = White,
            titleContentColor = Black
        ),
        title = {
            Text(
                text = title,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(start = 28.dp)
            )
        },
        actions = {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = DodgerBlue,
                    contentColor = White
                ),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .size(88.dp, 36.dp),
                onClick = {
                    isHelpClicked.value = true
                }
            ) {
                Text(
                    text = stringResource(R.string.help),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    )
    if (isHelpClicked.value) {
        HelpDialog(isHelpClicked)
    }
}