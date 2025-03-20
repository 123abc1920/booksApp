package com.example.bookapp.presentation.screens

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.bookapp.data.remotebooks.models.Volume
import com.example.bookapp.presentation.navigation.NowVol
import com.example.bookapp.presentation.theme.BookAppTheme

@Composable
fun DetailedInfoScreen(navController: NavController) {
    BookAppTheme {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                IconButton(onClick = { navController.navigate("home") }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Информация о приложении")
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Info, contentDescription = "Информация о приложении")
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
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
                    alignment = Alignment.Center
                )
                Text(
                    NowVol.vol?.volumeInfo?.authors.toString(),
                    textAlign = TextAlign.Center
                )
                Text(
                    NowVol.vol?.volumeInfo?.title ?: "Название",
                    textAlign = TextAlign.Center
                )
                Text(
                    NowVol.vol?.volumeInfo?.publishedDate ?: "0000",
                    textAlign = TextAlign.Center
                )
                Text(
                    "Описание:"
                )
                Text(
                    NowVol.vol?.volumeInfo?.description ?: "Описание",
                    modifier = Modifier.verticalScroll(rememberScrollState())
                )
            }
        }
    }

}