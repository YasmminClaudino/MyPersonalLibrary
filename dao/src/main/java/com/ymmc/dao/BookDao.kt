package com.ymmc.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(book: BookEntity)

    @Query("SELECT * FROM books WHERE status = :status")
    suspend fun getBooksByStatus(status: String): List<BookEntity>

    @Delete
    suspend fun deleteBook(book: BookEntity)
}