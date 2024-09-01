package com.ymmc.mypersonallibrary.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ymmc.backend.network.data.model.BookResponse
import com.ymmc.mypersonallibrary.data.model.Book
import com.ymmc.mypersonallibrary.databinding.ActivityMainBinding
import com.ymmc.mypersonallibrary.ui.adapter.BookAdapter
import com.ymmc.mypersonallibrary.ui.viewmodel.BookListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: BookListViewModel by viewModel()
    private val books = mutableListOf<Book>()

    private val adapter: BookAdapter by lazy {
        BookAdapter(books)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerLayout()
        setUpSearchField()
        observables()
    }

    private fun initRecyclerLayout() {
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.adapter = adapter
    }

    private fun setUpSearchField() {
        binding.searchIcon.setOnClickListener {
            val query = binding.searchBar.text.toString()
            viewModel.searchBooks(query)
        }
    }

    private fun observables() {
        viewModel.books.observe(this) { response ->
            filterBook(response)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun filterBook(response: BookResponse) {
        response.items.mapNotNull { booksInfo ->
            val id = booksInfo.id
            val bookName = booksInfo.volumeInfo.title ?: "Unknown Title"
            val authors = booksInfo.volumeInfo.authors.joinToString(", ") ?: "Unknown Author"
            val description = booksInfo.volumeInfo.description ?: "No description available"
            val thumbnail = booksInfo.volumeInfo.imageLinks?.thumbnail

            try {
                Book(id, bookName, authors, description, thumbnail)
            } catch (e: Exception) {
                Log.e(TAG, "Error creating book object for id $id: $e")
                null
            }
        }.let { newBooks ->
            books.clear()
            books.addAll(newBooks)
            adapter.notifyDataSetChanged()
        }
    }


    companion object {
        private const val TAG = "yaya"
    }
}