package com.biopic.freshcart

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.biopic.freshcart.ui.theme.Black
import com.biopic.freshcart.ui.theme.DodgerBlue
import com.biopic.freshcart.ui.theme.Grey
import com.biopic.freshcart.ui.theme.Red
import com.biopic.freshcart.ui.theme.White

@Composable
fun SignUpScreen(navController: NavController, user : User) {
    val nameText = remember {
        mutableStateOf("")
    }
    val emailText = remember {
        mutableStateOf("")
    }
    val passwordText = remember {
        mutableStateOf("")
    }
    val confirmPasswordText = remember {
        mutableStateOf("")
    }
    val isButtonClicked = remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    val errorToast = stringResource(R.string.error_toast_signUp)
    val confirmToast = stringResource(R.string.confirm_toast_signUp)

    val validName = isValidName(nameText.value)
    val validEmail = isValidEmail(emailText.value)
    val validPassword = isValidPassword(passwordText.value)
    val passwordMatched = passwordText.value == confirmPasswordText.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Profile image
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(160.dp, 160.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // TextField for Name
        OutlinedTextField(
            value = nameText.value,
            onValueChange = { name ->
                nameText.value = name
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
                    text = stringResource(R.string.namePlaceHolder),
                    color = Grey
                )
            },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Mail",
                    tint = Grey
                )
            },
            isError = isButtonClicked.value && !validName
        )

        Spacer(modifier = Modifier.height(20.dp))

        // TextField for Email
        OutlinedTextField(
            value = emailText.value,
            onValueChange = { email ->
                emailText.value = email
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
                    text = stringResource(R.string.emailPlaceHolder),
                    color = Grey
                )
            },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Email,
                    contentDescription = "Mail",
                    tint = Grey
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = isButtonClicked.value && !validEmail
        )
        Spacer(modifier = Modifier.height(20.dp))

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
                    text = stringResource(R.string.password_placeholder),
                    color = Grey
                )
            },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Lock,
                    contentDescription = "Mail",
                    tint = Grey
                )
            },
            isError = isButtonClicked.value && !validPassword
        )
        Spacer(modifier = Modifier.height(20.dp))


        // TextField for Confirm Password
        OutlinedTextField(
            value = confirmPasswordText.value,
            onValueChange = { confirmPassword ->
                confirmPasswordText.value = confirmPassword
            },
            modifier = Modifier
                .fillMaxWidth(0.84f),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = White,
                unfocusedContainerColor = White,

                focusedTextColor = Black,
                unfocusedTextColor = Black,

                focusedIndicatorColor = if (passwordMatched) Black else Red,
                unfocusedIndicatorColor = if (passwordMatched) Black else Red,

                errorIndicatorColor = Red,
                errorContainerColor = White,
                errorTextColor = Black
            ),
            placeholder = {
                Text(
                    text = stringResource(R.string.confirm_placeholder),
                    color = Grey
                )
            },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Lock,
                    contentDescription = "Mail",
                    tint = Grey
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = (isButtonClicked.value && !validPassword) || !passwordMatched
        )
        if (!passwordMatched) {
            Column(
                modifier = Modifier.fillMaxWidth(0.84f)
            ) {
                Text(
                    text = stringResource(R.string.password_match),
                    fontSize = 12.sp,
                    color = Red,
                    fontStyle = FontStyle.Italic
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
        else Spacer(modifier = Modifier.height(20.dp))

        // Sign Up Button
        Button(
            onClick = {
                focusManager.clearFocus()
                isButtonClicked.value = true
                val valid = validName && validEmail && validPassword && passwordMatched
                val invalid = !validName || !validEmail || !validPassword
                if (invalid) Toast.makeText(context, errorToast, Toast.LENGTH_SHORT).show()
                if (valid) {
                    user.name = nameText.value
                    user.email = emailText.value
                    user.password = passwordText.value
                    writeData(user, context)
                    navController.popBackStack()
                    Toast.makeText(context, confirmToast, Toast.LENGTH_SHORT).show()
                }
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
                text = stringResource(R.string.signUp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

fun isValidName(name: String): Boolean {
    return name.isNotBlank()
}

fun isValidEmail(email: String): Boolean {
    return email.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun isValidPassword(password: String): Boolean {
    return password.isNotBlank() && password.length >= 8
}