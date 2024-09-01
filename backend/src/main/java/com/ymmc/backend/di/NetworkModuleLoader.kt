package com.ymmc.backend.di

import com.ymmc.backend.network.ApiService
import com.ymmc.backend.network.data.repository.BookRepository
import com.ymmc.backend.network.data.repository.BookRepositoryImpl
import com.ymmc.backend.network.data.source.BookRepositoryDataSource
import com.ymmc.backend.network.data.source.BookRepositoryDataSourceImpl
import com.ymmc.core.ModuleLoader
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModuleLoader : ModuleLoader {

    private val networkModule = module {
        single {  Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        }
        single { get<Retrofit>().create(ApiService::class.java) }

        single<BookRepository> { BookRepositoryImpl(get()) }
        single<BookRepositoryDataSource> { BookRepositoryDataSourceImpl(get()) }
    }

    override fun load() {
        loadKoinModules(networkModule)
    }

}