package com.ymmc.dao.di

import androidx.room.Room
import com.ymmc.core.ModuleLoader
import com.ymmc.dao.BookDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object DataBaseModuleLoader: ModuleLoader {

    private val dataModuleLoader = module {
        single {
            Room.databaseBuilder(
                androidContext(),
                BookDataBase::class.java,
                "book_database"
            ).build()
        }
        single { get<BookDataBase>().bookDao() }

    }
    override fun load() {
        loadKoinModules(dataModuleLoader)
    }
}