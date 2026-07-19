package com.biopic.freshcart

object Screen{
    const val LOGIN = "LogIn"
    const val SIGNUP = "SignUp"
    const val FORGOTPASSWORD = "ForgotPassword"
    const val MAINSCREEN = "MainScreen"
    const val MAINSCREEN_ROUTE = "$MAINSCREEN/{name}"
    fun mainScreenRoute(name : String) : String {
        return "$MAINSCREEN/$name"
    }
}