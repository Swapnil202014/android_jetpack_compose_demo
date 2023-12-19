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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycompose.R
import com.example.mycompose.model.Restaurant
import com.example.mycompose.ui.theme.MyComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    RestaurantApp()
                }
            }
        }
    }
}

data class Restaurants(val name: String, val tagline: String, val imageId: Int)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantApp() {

    val restaurants = listOf(
        Restaurants("Atharva 1", "Best in the town!", R.drawable.restaurant),
        Restaurants("Atharva 2", "Best in the town!", R.drawable.restaurant),
        Restaurants("Atharva 3", "Best in the town!", R.drawable.restaurant),
        Restaurants("Atharva 4", "Best in the town!", R.drawable.restaurant),
        Restaurants("Atharva 5", "Best in the town!", R.drawable.restaurant),
        Restaurants("Atharva 6", "Best in the town!", R.drawable.restaurant),
        Restaurants("Atharva 7", "Best in the town!", R.drawable.restaurant),
        Restaurants("Atharva 8", "Best in the town!", R.drawable.restaurant),
        Restaurants("Atharva 9", "Best in the town!", R.drawable.restaurant),
        Restaurants("Atharva 10", "Best in the town!", R.drawable.restaurant),
        Restaurants("Atharva 11", "Best in the town!", R.drawable.restaurant)
    )

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "RestaurantApp", color = MaterialTheme.colorScheme.onPrimary
                )
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
        )
    }
//        , floatingActionButton = {
//        FloatingActionButton(onClick = { restaurants.add(restaurants.random()) }) {
//            Icon(
//                Icons.Filled.Add, contentDescription = "add restaurant"
//            )
//        }
//    }
    ) { contentPadding ->
//        RestaurantLists(contentPadding, restaurants)
//        RestaurantProfile(contentPadding, restaurants)
        RestaurantProfile(contentPadding, RestaurantViewModel())
    }
}

@Composable
fun RestaurantLists(
    contentPaddingValues: PaddingValues, restaurants: List<Restaurants>
) {
    Column(
        modifier = Modifier
            .padding(contentPaddingValues)
            .verticalScroll(rememberScrollState())
    ) {
        restaurants.forEach { restaurant -> RestaurantCard(restaurants = restaurant) }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun RestaurantProfile(contentPaddingValues: PaddingValues, restaurants: List<Restaurants>) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(contentPaddingValues),
//        shape = RectangleShape,
//        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
//        colors = CardDefaults.cardColors(Color.White)
//    ) {
//
//        var name by rememberSaveable { mutableStateOf("") }
//        var selectedIndex by rememberSaveable {
//            mutableStateOf(0)
//        }
//        var expanded by rememberSaveable {
//            mutableStateOf(false)
//        }
//        Box(modifier = Modifier.fillMaxSize()) {
//            Column(
//                modifier = Modifier
//                    .padding(8.dp)
//                    .align(Alignment.Center)
//            ) {
//                Box(modifier = Modifier.fillMaxWidth()) {
//                    if (name.isNotEmpty()) {
//                        Text(
//                            text = name,
//                            modifier = Modifier.align(Alignment.Center),
//                            style = MaterialTheme.typography.displayLarge
//                        )
//                    }
//                }
//                OutlinedTextField(
//                    value = name,
//                    onValueChange = { name = it },
//                    label = { Text(text = "Enter values") },
//                    modifier = Modifier.fillMaxWidth()
//                )
//            }
//
//        }
//    }
//}


//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun RestaurantProfile(contentPaddingValues: PaddingValues, restaurants: List<Restaurants>) {
//    var name by rememberSaveable { mutableStateOf("") }
//    var selectedIndex by rememberSaveable {
//        mutableIntStateOf(0)
//    }
//    var expanded by rememberSaveable {
//        mutableStateOf(false)
//    }
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(contentPaddingValues),
//        shape = RectangleShape,
//        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
//        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background)
//    ) {
//        Column(modifier = Modifier.fillMaxWidth()) {
//            Box(
//                modifier = Modifier
//                    .padding(31.dp)
//                    .fillMaxWidth()
//                    .wrapContentHeight()
//            ) {
//                Image(
//                    painter = painterResource(id = restaurants[selectedIndex].imageId),
//                    contentDescription = "restaurant",
//                    modifier = Modifier
//                        .align(Alignment.Center)
//                        .size(250.dp)
//                        .clip(CircleShape),
//                    contentScale = ContentScale.Crop
//                )
//            }
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .wrapContentSize(Alignment.BottomCenter)
//            ) {
//                Text(
//                    text = restaurants[selectedIndex].name,
//                    textAlign = TextAlign.Center,
//                    style = MaterialTheme.typography.titleLarge,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .clickable(onClick = { expanded = true })
//                        .padding(10.dp)
//                )
//                DropdownMenu(expanded = expanded,
//                    onDismissRequest = { expanded = false },
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    restaurants.forEachIndexed { index, s ->
//                        DropdownMenuItem(text = {
//                            Card(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(4.dp),
//                                colors = CardDefaults.cardColors(
//                                    MaterialTheme.colorScheme.background
//                                )
//                            ) {
//                                Text(text = s.name)
//                            }
//                        }, onClick = {
//                            selectedIndex = index
//                            expanded = false
//                        })
//                    }
//                }
//            }
//        }
//    }
//}

//@Composable
//fun RestaurantLists(
//    contentPaddingValues: PaddingValues, restaurants: List<Restaurants>
//) {
//    Row(
//        modifier = Modifier
//            .fillMaxHeight()
//            .padding(contentPaddingValues)
//            .horizontalScroll(rememberScrollState()),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        restaurants.forEach { restaurant -> RestaurantCard(restaurants = restaurant) }
//    }
//}

@Composable
fun RestaurantProfile(
    contentPaddingValues: PaddingValues, restaurantViewModel: RestaurantViewModel
) {
    val restaurantState: State<Restaurant?> = restaurantViewModel.restaurant.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(contentPaddingValues)
            .verticalScroll(rememberScrollState())
    ) {
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                restaurantState.value?.let { restaurant ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Image(
                            painter = painterResource(restaurant.image),
                            contentDescription = "Profile Restaurant",
                            modifier = Modifier
                                .align(Alignment.Center)
                                .clip(RoundedCornerShape(10.dp))
                                .size(300.dp),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(5.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = restaurant.name,
                                style = MaterialTheme.typography.headlineLarge
                            )
                            Text(text = restaurant.address)
                            Text(text = restaurant.phone)
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Ratings: ${restaurant.rating} ",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Cuisine: ${restaurant.cuisine} ")

                    restaurant.menuItem.forEach { menuItem ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = menuItem.name, style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                text = "$ ${menuItem.price}",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }


                }

            }
        }
        Card(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                restaurantState.value?.let { restaurant ->
                    RestRatingBar(rating = restaurant.rating,
                        onRatingChanged = { restaurantViewModel.updateRestaurantRating(it) })
                }
            }
        }
    }
}

@Composable
fun RestRatingBar(
    rating: Float, onRatingChanged: (Float) -> Unit
) {
    val currentRating = remember { mutableFloatStateOf(rating) }
    Row {
        RatingBar(rating = currentRating, onRatingChanged = {
            currentRating.value = it
            onRatingChanged(it)
        })
    }
}

@Composable
fun RatingBar(
    rating: MutableState<Float>, onRatingChanged: (Float) -> Unit
) {
    val maxRating = 5f
    Column(
        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            repeat(maxRating.toInt()) { index ->
                val currentRating = index + 1f
                val isSelected = currentRating <= rating.value
                Icon(imageVector = if (isSelected) Icons.Filled.Star
                else Icons.Outlined.Star,
                    contentDescription = null,
                    tint = if (isSelected) Color.Red else Color.LightGray,
                    modifier = Modifier
                        .clickable { onRatingChanged(currentRating) }
                        .padding(5.dp))
            }
        }
    }
}

@Composable
fun RestaurantCard(restaurants: Restaurants) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(Modifier.padding(8.dp)) {
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

//@Preview(showBackground = true, name = "restaurant", showSystemUi = true)
//@Composable
//fun PreviewGreeting() {
//    MyComposeTheme {
//        RestaurantCard(Restaurants("ABC", "ABC tagline", R.drawable.restaurant))
//    }
//}

@Preview(
    showBackground = true,
    name = "restaurantList",
    showSystemUi = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
fun RestaurantCard() {
    MyComposeTheme {
        RestaurantApp()
    }
}
