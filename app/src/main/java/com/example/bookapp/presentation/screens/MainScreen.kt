package com.example.bookapp.presentation.screens

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.bookapp.data.remotebooks.Consts
import com.example.bookapp.data.remotebooks.Service
import com.example.bookapp.data.remotebooks.models.BooksResponse
import com.example.bookapp.data.remotebooks.models.Volume
import com.example.bookapp.presentation.navigation.NowVol
import com.example.bookapp.presentation.theme.BookAppTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var mService: Service
lateinit var vols: List<Volume>

@Composable
fun MainScreen(navController: NavController) {
    var text by remember { mutableStateOf("") }
    var volumess by remember { mutableStateOf<List<Volume>?>(null) }
    mService = Consts.service

    if (!text.equals("") || text != null) {
        getAllBooksList(text) { volumes ->
            if (volumes != null) {
                volumess = volumes
                vols = volumes
            } else {
            }
        }
    }

    BookAppTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            Column {
                TextField(
                    value = text,
                    onValueChange = { newText -> text = newText },
                    label = { Text("Поиск") },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            Column(
                content = {
                    volumess?.let { BookListItem(it, navController) }
                },
                modifier = Modifier
                    .fillMaxHeight(0.8f)
                    .fillMaxWidth(1f)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(
                    onClick = { navController.navigate("home") },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(verticalArrangement = Arrangement.Center) {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = "Информация о приложении",
                            tint = Color(red = 0x00, green = 0xAC, blue = 0xFF, alpha = 0xFF)
                        )
                        Text(
                            "Поиск",
                            color = Color(red = 0x00, green = 0xAC, blue = 0xFF, alpha = 0xFF)
                        )
                    }
                }
                IconButton(
                    onClick = { navController.navigate("favourite") },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(verticalArrangement = Arrangement.Center) {
                        Icon(Icons.Filled.Done, contentDescription = "Информация о приложении")
                        Text("Избранное")
                    }
                }
            }
        }
    }
}

@Composable
fun BookListItem(volumes: List<Volume>, navController: NavController) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        modifier = Modifier.fillMaxWidth(1f)
    ) {
        items(volumes.size / 2) { index ->
            if (index % 2 == 0) {
                Row {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .background(Color.Transparent)
                            .clickable {
                                NowVol.vol = volumes.get(index)
                                navController.navigate("detailedInfo")
                            }) {
                        Box {
                            AsyncImage(
                                model = volumes.get(index).volumeInfo.imageLinks.thumbnail.toString(),
                                contentDescription = "Image description",
                                modifier = Modifier
                                    .clipToBounds()
                                    .height(180.dp)
                                    .width(128.dp)
                                    .layoutId("imageSection")
                                    .clip(RoundedCornerShape(8.dp)),
                                error = painterResource(id = R.drawable.star_on),
                            )
                            IconButton(onClick = { }, modifier = Modifier.align(Alignment.TopEnd)) {
                                Icon(Icons.Filled.Done, contentDescription = "")
                            }
                        }
                        Text(text = volumes.get(index).volumeInfo.title)
                    }
                    if (index + 1 < volumes.size) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .background(Color.Transparent)
                                .clickable {
                                    NowVol.vol = volumes.get(index + 1)
                                    navController.navigate("detailedInfo")
                                }) {
                            Box {
                                AsyncImage(
                                    model = volumes.get(index + 1).volumeInfo.imageLinks.thumbnail.toString(),
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
                                IconButton(
                                    onClick = { },
                                    modifier = Modifier.align(Alignment.TopEnd)
                                ) {
                                    Icon(Icons.Filled.Done, contentDescription = "")
                                }
                            }
                            Text(
                                text = volumes.get(index + 1).volumeInfo.title,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun getAllBooksList(target: String, callback: (List<Volume>?) -> Unit) {
    mService.getBooksList(target).enqueue(object : Callback<BooksResponse> {
        override fun onFailure(call: Call<BooksResponse>, t: Throwable) {
            callback(null)
        }

        override fun onResponse(
            call: Call<BooksResponse>,
            response: Response<BooksResponse>
        ) {
            if (response.isSuccessful) {
                val books: BooksResponse? = response.body()
                callback(books?.items)
            } else {
                callback(null)
            }
        }
    })
}