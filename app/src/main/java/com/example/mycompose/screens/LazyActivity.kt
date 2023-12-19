package com.example.mycompose.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
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

class LazyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    RestaurantApp1()
                }
            }
        }
    }
}

data class LazyRestaurant(val id: Int, val name: String, val tagline: String, val imageId: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantApp1() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val snackBarHostState = remember {
        SnackbarHostState()
    }
    val lazyRestaurant = remember {
        mutableStateListOf(
            LazyRestaurant(11, "Atharva 1", "Best in the town!", R.drawable.restaurant),
            LazyRestaurant(12, "Atharva 2", "Best in the town!", R.drawable.restaurant),
            LazyRestaurant(13, "Atharva 3", "Best in the town!", R.drawable.restaurant),
            LazyRestaurant(14, "Atharva 4", "Best in the town!", R.drawable.restaurant),
            LazyRestaurant(15, "Atharva 5", "Best in the town!", R.drawable.restaurant),
            LazyRestaurant(16, "Atharva 6", "Best in the town!", R.drawable.restaurant),
            LazyRestaurant(1, "Atharva 7", "Best in the town!", R.drawable.restaurant),
            LazyRestaurant(2, "Atharva 8", "Best in the town!", R.drawable.restaurant),
            LazyRestaurant(3, "Atharva 9", "Best in the town!", R.drawable.restaurant),
            LazyRestaurant(4, "Atharva 10", "Best in the town!", R.drawable.restaurant),
            LazyRestaurant(5, "Atharva 11", "Best in the town!", R.drawable.restaurant)
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
                    listState.animateScrollToItem(index = lazyRestaurant.size - 1)
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
                contentPadding, lazyRestaurant, listState, snackBarHostState
            )
            SnackbarHost(
                hostState = snackBarHostState, modifier = Modifier.align(Alignment.BottomCenter)

            ) { data ->
                Snackbar(snackbarData = data)
            }
        }
    }
}


@Composable
fun RestaurantProfile1(
    contentPaddingValues: PaddingValues,
    restaurants: List<LazyRestaurant>,
    listState: LazyListState,
    snackBarHostState: SnackbarHostState
) {

    LazyColumn(
        modifier = Modifier.padding(contentPaddingValues),
        verticalArrangement = Arrangement.spacedBy(4.dp)
//        , state = listState
    ) {
//        item {
//            Box(modifier = Modifier.padding(10.dp)) {
//                Text(text = "Fist Item in Lazy column")
//            }
//        }

        items(items = restaurants,
            key = { restaurant ->
                restaurant.id
            }) { item ->
            val rememberValue = rememberSaveable(item) {
                mutableIntStateOf(0)
            }
            RestaurantCard2(restaurants = item, rememberValue, snackBarHostState)
        }
//        items(100) { item ->
//            Box(modifier = Modifier.padding(10.dp)) {
//                Text(text = "Lazy Column Item Count : ${100 + item}")
//            }
//        }

//        item {
//            Box(modifier = Modifier.padding(10.dp)) {
//                Text(text = "Last Item in Lazy column")
//            }
//        }
    }
}


@Preview(
    showBackground = true,
    name = "restaurantList",
    showSystemUi = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
fun RestaurantCard1() {
    MyComposeTheme {
        RestaurantApp1()
    }
}

@Composable
fun RestaurantCard2(
    restaurants: LazyRestaurant,
    rememberValue: MutableState<Int>,
    snackBarHostState: SnackbarHostState
) {
    val coroutineScope = rememberCoroutineScope()
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            Modifier
                .padding(8.dp)
                .clickable(onClick = {
                    rememberValue.value++
                    coroutineScope.launch {
                        snackBarHostState.showSnackbar(
                            message = "${restaurants.name} has ${rememberValue.value}",
                            duration = SnackbarDuration.Short
                        )
                    }
                })
        ) {
            Image(
                painter = painterResource(id = R.drawable.restaurant),
                contentDescription = "restaurants",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(width = 2.dp, Color.Black, shape = CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = "Hello ${restaurants.name}!", Modifier.padding(
                        start = 5.dp, end = 32.dp
                    ), style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "Hello ${restaurants.tagline}!", Modifier.padding(
                        start = 5.dp, bottom = 30.dp
                    ), style = MaterialTheme.typography.titleSmall
                )
            }
        }

    }

}