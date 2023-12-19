package com.example.mycompose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RestaurantScreen(
    contentPaddingValues: PaddingValues,
    restaurantName: String?,
    onTitleChanged: (String) -> Unit,
    navigateToInputHomeScreen: () -> Unit
) {
    onTitleChanged("$restaurantName")
    Box(
        modifier = Modifier
            .padding(contentPaddingValues)
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(
                text = "Welcome to $restaurantName",
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = navigateToInputHomeScreen) {
                Text(text = "Go back to input home")
            }
        }
    }
}