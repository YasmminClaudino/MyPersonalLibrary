package com.ymmc.backend.network.data.model

data class VolumeInfo (
    val title: String,
    val authors: List<String>,
    val description: String,
    val imageLinks: ImageLinks?
)