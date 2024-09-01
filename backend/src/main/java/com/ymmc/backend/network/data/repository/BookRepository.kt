package com.ymmc.backend.network.data.repository

import com.ymmc.backend.network.data.model.BookResponse

interface BookRepository {
   suspend fun getBooks(query: String): BookResponse?
}