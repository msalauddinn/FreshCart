package com.biopic.freshcart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Product(
    val id : Int,
    val category : String,
    val name : String,
    val mrp : Int,
    val discount : Int,
    val originalPrice : Int,
    val unit : String,
    stock : Int,
    val image : Int,
    val rating : Float,
    val smallDescription : String,
    val bigDescription : String
) {
    var stock by mutableIntStateOf(stock)
    var itemCount by mutableIntStateOf(1)
    var isAddedCart by mutableStateOf(false)
    var isFavorite by mutableStateOf(false)
}