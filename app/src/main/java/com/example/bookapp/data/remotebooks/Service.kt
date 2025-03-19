package com.example.bookapp.data.remotebooks

import com.example.bookapp.data.remotebooks.models.BooksResponse
import retrofit2.Call
import retrofit2.http.GET

interface Service {

    @GET("volumes?q=Harry")
    fun getBooksList(): Call<BooksResponse>
}