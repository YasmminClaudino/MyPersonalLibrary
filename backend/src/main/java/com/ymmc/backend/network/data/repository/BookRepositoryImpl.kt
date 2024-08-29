package com.ymmc.backend.network.data.repository

import com.ymmc.backend.network.data.model.BookResponse
import com.ymmc.backend.network.data.source.BookRepositoryDataSource


class BookRepositoryImpl(
    private val bookRepositoryDataSource: BookRepositoryDataSource
): BookRepository {
    override suspend fun getBooks(query: String): BookResponse {
       return bookRepositoryDataSource.getBooks(query)
    }
}