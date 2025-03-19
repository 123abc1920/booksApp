package com.example.bookapp.data.remotebooks.models

data class Book (
    val kind: String,
    val totalItems: Int,
    val items: List<Volume>
)