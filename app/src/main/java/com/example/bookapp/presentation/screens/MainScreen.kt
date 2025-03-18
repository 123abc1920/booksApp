package com.example.bookapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bookapp.presentation.theme.BookAppTheme

@Preview(showBackground = true)
@Composable
fun MainScreen() {
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
                        .fillMaxWidth()
                )
            }
            Row {
                Button(onClick = {}) {
                    Text(
                        "Поиск",
                        modifier = Modifier.fillMaxWidth(0.5f)
                    )
                }
                Button(onClick = {}) {
                    Text(
                        "Избранное",
                        modifier = Modifier.fillMaxWidth(0.5f)
                    )
                }
            }
        }
    }
}