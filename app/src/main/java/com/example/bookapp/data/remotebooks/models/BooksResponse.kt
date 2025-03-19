package com.example.bookapp.data.remotebooks.models

data class BooksResponse (
    val kind: String,
    val totalItems: Int,
    val items: List<Volume>
)