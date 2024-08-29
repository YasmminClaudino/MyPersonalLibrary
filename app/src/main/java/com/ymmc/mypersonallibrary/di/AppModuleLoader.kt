package com.ymmc.mypersonallibrary.di

import com.ymmc.core.ModuleLoader
import com.ymmc.mypersonallibrary.ui.viewmodel.BookListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object AppModuleLoader : ModuleLoader {

    private val appModule = module {
        viewModel { BookListViewModel(get()) }
    }
    override fun load() {
        loadKoinModules(appModule)
    }

}