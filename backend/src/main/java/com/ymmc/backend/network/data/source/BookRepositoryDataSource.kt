package com.ymmc.backend.network.data.source

import com.ymmc.backend.network.data.model.BookResponse

interface BookRepositoryDataSource {
    suspend fun getBooks(query: String): BookResponse
}