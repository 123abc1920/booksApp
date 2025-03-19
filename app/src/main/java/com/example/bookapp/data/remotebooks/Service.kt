package com.example.bookapp.data.remotebooks

import com.example.bookapp.data.remotebooks.models.BooksResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("volumes")
    fun getBooksList(@Query("q") query: String): Call<BooksResponse>
}