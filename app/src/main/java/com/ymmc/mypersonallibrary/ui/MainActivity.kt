package com.ymmc.mypersonallibrary.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ymmc.mypersonallibrary.databinding.ActivityMainBinding
import com.ymmc.mypersonallibrary.ui.viewmodel.BookListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: BookListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.searchBooks("harry potter")
        observables()
    }

    private fun observables() {
        viewModel.books.observe(this) {
            Log.d(TAG, "observeables: $it")
        }
    }

    companion object {
        private const val TAG = "yaya"
    }
}