package com.example.bookapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bookapp.presentation.theme.BookAppTheme

@Composable
fun FavouriteScreen(navController: NavController) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Избранное",
                modifier = Modifier
                    .fillMaxHeight(0.8f)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth().wrapContentHeight(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = { navController.navigate("home") },
                modifier = Modifier.weight(1f)
            ) {
                Column(verticalArrangement = Arrangement.Center) {
                    Icon(Icons.Filled.Search, contentDescription = "Информация о приложении")
                    Text("Поиск")
                }
            }
            IconButton(
                onClick = { navController.navigate("favourite") },
                modifier = Modifier.weight(1f)
            ) {
                Column(verticalArrangement = Arrangement.Center) {
                    Icon(
                        Icons.Filled.Done,
                        contentDescription = "Информация о приложении",
                        tint = Color(red = 0x00, green = 0xAC, blue = 0xFF, alpha = 0xFF)
                    )
                    Text("Избранное", color = Color(red = 0x00, green = 0xAC, blue = 0xFF, alpha = 0xFF))
                }
            }
        }
    }
}
