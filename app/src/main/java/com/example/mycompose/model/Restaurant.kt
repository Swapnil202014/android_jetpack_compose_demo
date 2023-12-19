package com.example.mycompose.model

data class Restaurant(
    val name: String,
    val address: String,
    val phone: String,
    val rating: Float,
    val image: Int,
    val cuisine: String,
    val menuItem: List<MenuItem>
)
