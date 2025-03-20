package com.example.bookapp.presentation.screens

import android.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.bookapp.data.remotebooks.models.Volume
import com.example.bookapp.presentation.navigation.NowVol
import com.example.bookapp.presentation.theme.BookAppTheme

@Composable
fun DetailedInfoScreen(navController: NavController) {
    BookAppTheme {
        Column {
            Row {
                Button(onClick = { navController.navigate("home") }) {
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
                AsyncImage(
                    model = NowVol.vol?.volumeInfo?.imageLinks?.thumbnail,
                    contentDescription = "Image description",
                    modifier = Modifier
                        .clipToBounds()
                        .height(180.dp)
                        .width(128.dp)
                        .layoutId("imageSection")
                        .clip(RoundedCornerShape(8.dp)),
                    error = painterResource(id = R.drawable.star_on),
                )
                Text(
                    NowVol.vol?.volumeInfo?.authors.toString()
                )
                Text(
                    NowVol.vol?.volumeInfo?.title ?: "Название"
                )
                Text(
                    NowVol.vol?.volumeInfo?.publishedDate ?: "0000"
                )
                Text(
                    "Описание"
                )
                Text(
                    NowVol.vol?.volumeInfo?.description ?: "Описание"
                )
            }
        }
    }

}