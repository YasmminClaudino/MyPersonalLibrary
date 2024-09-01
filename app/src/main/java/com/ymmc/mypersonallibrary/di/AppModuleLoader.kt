package com.ymmc.mypersonallibrary.di

import android.content.Context
import android.content.SharedPreferences
import com.ymmc.core.ModuleLoader
import com.ymmc.mypersonallibrary.data.repository.UserInfoRepository
import com.ymmc.mypersonallibrary.data.repository.UserInfoRepositoryImpl
import com.ymmc.mypersonallibrary.data.source.UserInfoDataSource
import com.ymmc.mypersonallibrary.data.source.UserInfoDataSourceImpl
import com.ymmc.mypersonallibrary.ui.viewmodel.BookListViewModel
import com.ymmc.mypersonallibrary.ui.viewmodel.DummyLoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object AppModuleLoader : ModuleLoader {

    private val appModule = module {
        // ViewModel
        viewModel { BookListViewModel(get()) }
        viewModel { DummyLoginViewModel(get()) }

        single<UserInfoRepository> { UserInfoRepositoryImpl(get()) }
        single<UserInfoDataSource> { UserInfoDataSourceImpl(get()) }
        single<SharedPreferences> {
            get<Context>().getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE)
        }

    }
    override fun load() {
        loadKoinModules(appModule)
    }

}