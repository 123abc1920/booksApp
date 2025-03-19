package com.example.bookapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.bookapp.presentation.theme.BookAppTheme

@Composable
fun DetailedInfoScreen(navController: NavController) {
    BookAppTheme {
        Column {
            Row {
                Button(onClick = {}) {
                    Text(
                        "Назад"
                    )
                }
                Button(onClick = {}) {
                    Text(
                        "Уже"
                    )
                }
            }
            Column {
                Image(
                    painter = ColorPainter(Color.DarkGray),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .fillMaxHeight(0.7f),
                    contentDescription = "Черный квадрат"
                )
                Text(
                    "Автор"
                )
                Text(
                    "Название"
                )
                Text(
                    "Год"
                )
                Text(
                    "Описание"
                )
                Text(
                    "Само описание"
                )
            }
        }
    }

}