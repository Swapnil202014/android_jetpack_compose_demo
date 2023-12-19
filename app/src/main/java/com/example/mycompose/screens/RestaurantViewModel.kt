package com.example.mycompose.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycompose.model.MenuItem
import com.example.mycompose.model.Restaurant

class RestaurantViewModel : ViewModel() {
    private val _restaurant = MutableLiveData<Restaurant>()
    val restaurant: LiveData<Restaurant> = _restaurant

    init {
        _restaurant.value = Restaurant(
            name = "Loony Cafe",
            address = "1234 Main St, USA",
            phone = "5555-1234-345",
            rating = 0f,
            image = R.drawable.restaurant,
            cuisine = "Italian",
            menuItem = listOf(
                MenuItem(name = "Spaghetti", price = 5.55f),
                MenuItem(name = "Lasagna", price = 54.55f),
                MenuItem(name = "Pizza", price = 15.55f)
            )
        )
    }

    fun updateRestaurantRating(rating: Float) {
        _restaurant.value = _restaurant.value?.copy(rating = rating)
    }
}