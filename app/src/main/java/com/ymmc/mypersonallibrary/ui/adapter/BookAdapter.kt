package com.ymmc.mypersonallibrary.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ymmc.mypersonallibrary.R
import com.ymmc.mypersonallibrary.data.model.Book
import com.ymmc.mypersonallibrary.databinding.BookInfosBinding

class BookAdapter(private val books: List<Book>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    inner class BookViewHolder(private val binding: BookInfosBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) {
            binding.title.text = book.title
            binding.author.text = book.authors
            Glide.with(binding.thumbnail.context)
                .load(book.thumbnail?.replace("http://", "https://"))
                .error(R.drawable.ic_launcher_background)
                .into(binding.thumbnail)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = BookInfosBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount() = books.size
}
