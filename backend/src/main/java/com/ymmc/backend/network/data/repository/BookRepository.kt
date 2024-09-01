package com.ymmc.backend.network.data.repository

import com.ymmc.backend.network.data.model.BookResponse
import retrofit2.Response

interface BookRepository {
   suspend fun getBooks(query: String): BookResponse?
}