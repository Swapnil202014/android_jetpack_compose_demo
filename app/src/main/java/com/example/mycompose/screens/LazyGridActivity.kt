package com.example.mycompose.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycompose.ui.theme.MyComposeTheme
import kotlinx.coroutines.launch

class LazyGridActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    RestaurantLazyGrid()
                }
            }
        }
    }
}

data class LazyGridRestaurant
    (val id: Int, val name: String, val tagline: String, val imageId: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantLazyGrid() {

    val lazyGrid = rememberLazyGridState()
    val coroutineScope = rememberCoroutineScope()
    val lazyRestaurant = remember {
        mutableStateListOf(
            LazyGridRestaurant
                (11, "Atharva 1", "Best in the town!", R.drawable.restaurant),
            LazyGridRestaurant
                (12, "Atharva 2", "Best in the town!", R.drawable.restaurant),
            LazyGridRestaurant
                (13, "Atharva 3", "Best in the town!", R.drawable.restaurant),
            LazyGridRestaurant
                (14, "Atharva 4", "Best in the town!", R.drawable.restaurant),
            LazyGridRestaurant
                (15, "Atharva 5", "Best in the town!", R.drawable.restaurant),
            LazyGridRestaurant
                (16, "Atharva 6", "Best in the town!", R.drawable.restaurant),
            LazyGridRestaurant
                (1, "Atharva 7", "Best in the town!", R.drawable.restaurant),
            LazyGridRestaurant
                (2, "Atharva 8", "Best in the town!", R.drawable.restaurant),
            LazyGridRestaurant
                (3, "Atharva 9", "Best in the town!", R.drawable.restaurant),
            LazyGridRestaurant
                (4, "Atharva 10", "Best in the town!", R.drawable.restaurant),
            LazyGridRestaurant
                (5, "Atharva 11", "Best in the town!", R.drawable.restaurant)
        )
    }


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "RestaurantApp", color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )

        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                lazyRestaurant.add(lazyRestaurant.random())
                coroutineScope.launch {
                    lazyGrid.animateScrollToItem(index = lazyRestaurant.size - 1)
                }
            }) {
                Icon(
                    Icons.Filled.Add, contentDescription = "add restaurant"
                )
            }
        },
    ) { contentPadding ->
        Box {
            RestaurantProfile1(
                contentPadding, lazyRestaurant, lazyGrid
            )

        }
    }
}


@Composable
fun RestaurantProfile1(
    contentPaddingValues: PaddingValues,
    restaurants: List<LazyGridRestaurant>,
    gridState: LazyGridState
) {

    LazyVerticalGrid(
        contentPadding = contentPaddingValues,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        state = gridState,
        columns = GridCells.Fixed(2)
    ) {
        items(items = restaurants) {
            RestaurantCard2(restaurants = it)
        }
    }
}


@Preview(
    showBackground = true,
    name = "restaurantList",
    showSystemUi = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
fun RestaurantCard3() {
    MyComposeTheme {
        RestaurantLazyGrid()
    }
}

@Composable
fun RestaurantCard2(
    restaurants: LazyGridRestaurant
) {
    val coroutineScope = rememberCoroutineScope()
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.restaurant),
            contentDescription = "restaurants",
            modifier = Modifier
                .size(200.dp)
                .clip(RectangleShape)
                .border(width = 2.dp, Color.Black, shape = RectangleShape),
            contentScale = ContentScale.Crop
        )
    }

}