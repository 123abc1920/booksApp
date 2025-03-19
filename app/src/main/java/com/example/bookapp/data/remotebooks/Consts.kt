package com.example.bookapp.data.remotebooks

object Consts {
    private val BASE_URL = "https://www.googleapis.com/books/v1/"
    val service: Service
        get() = Client.getClient(BASE_URL).create(Service::class.java)
}