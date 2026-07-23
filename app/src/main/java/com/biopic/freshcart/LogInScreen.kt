package com.biopic.freshcart

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.biopic.freshcart.ui.theme.Black
import com.biopic.freshcart.ui.theme.DodgerBlue
import com.biopic.freshcart.ui.theme.Grey
import com.biopic.freshcart.ui.theme.Red
import com.biopic.freshcart.ui.theme.RoyalBlue
import com.biopic.freshcart.ui.theme.White

@Composable
fun LogInScreen(navController: NavController, user : User) {
    val emailText = remember {
        mutableStateOf("")
    }
    val passwordText = remember {
        mutableStateOf("")
    }
    val isPasswordVisible = remember {
        mutableStateOf(false)
    }
    val isButtonClicked = remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    val validEmail = isValidEmail(emailText.value)
    val validPassword = isValidPassword(passwordText.value)

    val toastUserNotExist = stringResource(R.string.user_not_exist)
    val errorToast = stringResource(R.string.error_toast_signUp)
    val confirmToast = stringResource(R.string.confirm_toast_logIn)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profile Picture
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(160.dp, 160.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // TextField for Email
        OutlinedTextField(
            value = emailText.value,
            onValueChange = { emailOrPhone ->
                emailText.value = emailOrPhone
            },
            modifier = Modifier
                .fillMaxWidth(0.84f),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = White,
                unfocusedContainerColor = White,

                focusedTextColor = Black,
                unfocusedTextColor = Black,

                focusedIndicatorColor = Black,
                unfocusedIndicatorColor = Black,

                errorContainerColor = White,
                errorTextColor = Black,
                errorIndicatorColor = Red
            ),
            placeholder = {
                Text(
                    text = stringResource(R.string.emailPlaceHolder),
                    color = Grey
                )
            },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Mail,
                    contentDescription = "Mail",
                    tint = Grey
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = !validEmail && isButtonClicked.value
        )

        Spacer(modifier = Modifier.height(32.dp))

        // TextField for Password
        OutlinedTextField(
            value = passwordText.value,
            onValueChange = { password ->
                passwordText.value = password
            },
            modifier = Modifier
                .fillMaxWidth(0.84f),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = White,
                unfocusedContainerColor = White,

                focusedTextColor = Black,
                unfocusedTextColor = Black,

                focusedIndicatorColor = Black,
                unfocusedIndicatorColor = Black,

                errorContainerColor = White,
                errorIndicatorColor = Red,
                errorTextColor = Black
            ),
            placeholder = {
                Text(
                    text = stringResource(R.string.passwordPlaceHolder),
                    color = Grey
                )
            },
            singleLine = true,
            trailingIcon = {
                IconButton(
                    onClick = {
                        isPasswordVisible.value = !isPasswordVisible.value
                    }
                ) {
                    Icon(
                        imageVector = if (!isPasswordVisible.value) Icons.Outlined.VisibilityOff else Icons.Outlined.Visibility,
                        contentDescription = "Eye",
                        tint = Black
                    )
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            isError = !validPassword && isButtonClicked.value
        )

        // Forgot password text
        Column(
            modifier = Modifier
                .fillMaxWidth(0.84f)
        ) {
            TextButton(
                onClick = {
                    navController.navigate(Screen.FORGOTPASSWORD)
                }
            ) {
                Text(
                    text = stringResource(R.string.forgotPassword),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = RoyalBlue
                )
            }
        }

        // Log in Button
        Button(
            onClick = {
                focusManager.clearFocus()
                isButtonClicked.value = true
                if (validEmail && validPassword) {
                    if (user.email == emailText.value && user.password == passwordText.value) {
                        navController.navigate(route = Screen.MAINSCREEN) {
                            popUpTo(route = Screen.LOGIN) { inclusive = true }
                        }
                        Toast.makeText(context, confirmToast, Toast.LENGTH_SHORT).show()
                        val session = Session(true)
                        writeSessionData(session, context)
                    }
                    else {
                        Toast.makeText(context, toastUserNotExist, Toast.LENGTH_SHORT).show()
                    }
                }
                else Toast.makeText(context, errorToast, Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .fillMaxWidth(0.84f)
                .height(56.dp),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                containerColor = DodgerBlue,
                contentColor = White
            )
        ) {
            Text(
                text = stringResource(R.string.logIn),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Create one text
        Column(
            modifier = Modifier
                .fillMaxWidth(0.84f)
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.have_account),
                    color = Black
                )
                TextButton(
                    onClick = {
                        navController.navigate(Screen.SIGNUP)
                    }
                ) {
                    Text(
                        text = stringResource(R.string.create),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = RoyalBlue
                    )
                }
            }
        }
    }
}