package com.example.bookapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.bookapp.presentation.theme.BookAppTheme

@Composable
fun MainScreen(navController: NavController) {
    var text by remember { mutableStateOf("") }
    BookAppTheme {
        Column {
            Column {
                TextField(
                    value = text,
                    onValueChange = { newText -> text = newText },
                    label = { Text("Поиск") },
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "Введите название книги",
                    modifier = Modifier
                        .fillMaxHeight(0.8f)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Bottom
            ) {
                Button(
                    onClick = {navController.navigate("home")},
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Поиск")
                }
                Button(
                    onClick = {navController.navigate("favourite")},
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Избранное")
                }
            }
        }
    }
}