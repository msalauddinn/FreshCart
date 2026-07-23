package com.biopic.freshcart

import java.io.Serializable

data class User (
    var name : String = "",
    var email : String = "",
    var password : String = "",
    val favoriteProducts : MutableList<Int> = mutableListOf(),
    val cartItems : MutableMap<Int, Int> = mutableMapOf()
) : Serializable