package com.ymmc.mypersonallibrary.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ymmc.backend.network.data.model.BookData
import com.ymmc.backend.network.data.repository.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookListViewModel(
    private val repository: BookRepository
) : ViewModel() {

    private val _books = MutableLiveData<List<BookData>>()
    val books: LiveData<List<BookData>> = _books

    fun searchBooks(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
             repository.getBooks(query)
        }
    }
}