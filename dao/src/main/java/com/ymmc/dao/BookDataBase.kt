package com.ymmc.dao

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BookEntity::class], version = 1)
abstract class BookDataBase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}