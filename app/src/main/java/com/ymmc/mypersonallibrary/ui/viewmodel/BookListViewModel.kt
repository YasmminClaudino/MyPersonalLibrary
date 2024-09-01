package com.ymmc.mypersonallibrary.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ymmc.backend.network.data.model.BookResponse
import com.ymmc.backend.network.data.repository.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookListViewModel(
    private val repository: BookRepository
) : ViewModel() {

    private val _books = MutableLiveData<BookResponse>()
    var books: LiveData<BookResponse> = _books

    fun searchBooks(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
             _books.postValue(repository.getBooks(query))
        }
    }
}