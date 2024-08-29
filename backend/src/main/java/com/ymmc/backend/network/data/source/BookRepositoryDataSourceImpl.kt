package com.ymmc.backend.network.data.source

import com.ymmc.backend.network.ApiService
import com.ymmc.backend.network.data.model.BookResponse

class BookRepositoryDataSourceImpl(
    private val apiService: ApiService
): BookRepositoryDataSource {
    override suspend fun getBooks(query: String): BookResponse {
        return apiService.searchBooks(query)
    }
}