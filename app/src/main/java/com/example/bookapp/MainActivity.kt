package com.example.bookapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bookapp.presentation.screens.MainScreen
import com.example.bookapp.presentation.theme.BookAppTheme
import androidx.navigation.compose.rememberNavController
import com.example.bookapp.presentation.navigation.BookAppGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }

    @Composable
    fun App() {
        val navController = rememberNavController()

        BookAppTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                BookAppGraph(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }

    }
}