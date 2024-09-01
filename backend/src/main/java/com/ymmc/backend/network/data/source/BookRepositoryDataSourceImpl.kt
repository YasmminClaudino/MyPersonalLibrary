package com.ymmc.backend.network.data.source

import android.util.Log
import com.ymmc.backend.network.ApiService
import com.ymmc.backend.network.data.model.BookResponse
import retrofit2.Call
import retrofit2.Response

class BookRepositoryDataSourceImpl(
    private val apiService: ApiService
): BookRepositoryDataSource {
    override suspend fun getBooks(query: String): BookResponse? {
        val response = apiService.searchBooks(query)
        val bookResponse = response.body()
        Log.d("yaya", "getBooks: $bookResponse")
        return bookResponse
    }
}