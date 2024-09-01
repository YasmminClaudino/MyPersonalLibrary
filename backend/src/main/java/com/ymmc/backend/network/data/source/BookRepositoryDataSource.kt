package com.ymmc.backend.network.data.source

import com.ymmc.backend.network.data.model.BookResponse
import retrofit2.Call
import retrofit2.Response

interface BookRepositoryDataSource {
   suspend fun getBooks(query: String): BookResponse?
}