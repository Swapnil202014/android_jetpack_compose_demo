package com.example.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycompose.navigation.NavigationGraph
import com.example.mycompose.navigation.Screen
import com.example.mycompose.ui.theme.MyComposeTheme

class HomeScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    NavigationApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationApp() {
    var appBarTitle = remember {
        mutableStateOf("")
    }
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = appBarTitle.value,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
        )
    }

    ) { contentPadding ->
        NavigationGraph(contentPadding) {
            appBarTitle.value = it
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
fun RestaurantCard10() {
    NavigationGraph(PaddingValues(0.dp)) {
        Screen.Explore.route
    }
}


