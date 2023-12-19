package com.example.mycompose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputHomeScreen(
    contentPaddingValues: PaddingValues,
    onTitleChanged: (String) -> Unit,
    navigateToRestaurantScreen: (String) -> Unit
) {
    onTitleChanged("Eatelicious")
    Card(
        modifier = Modifier
            .padding(contentPaddingValues)
            .fillMaxWidth(),
        shape = RectangleShape,
    ) {
        var name by remember { mutableStateOf("") }
        Box(modifier = Modifier.fillMaxWidth()) {
            Column {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text(text = "Enter Rest. Name") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = { navigateToRestaurantScreen(name) }) {
                    Text(text = "View Restaurant")
                }
            }
        }
    }
}