package com.biopic.freshcart

data class Product(
    val id : Int,
    val category : String,
    val name : String,
    val mrp : Int,
    val discount : Int,
    val originalPrice : Int,
    val unit : String,
    val stock : Int,
    val image : Int,
    val rating : Float,
    val smallDescription : String,
    val bigDescription : String
)