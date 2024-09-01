package com.ymmc.backend.network.data.model

data class BookResponse (
    val kind: String,
    val totalItems: Int,
    val items: List<BookData>
)