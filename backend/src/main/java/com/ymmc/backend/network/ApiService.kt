package com.ymmc.backend.network

import com.ymmc.backend.network.data.model.BookResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("volumes")
    suspend fun searchBooks(
        @Query("q") query: String
    ): BookResponse
}