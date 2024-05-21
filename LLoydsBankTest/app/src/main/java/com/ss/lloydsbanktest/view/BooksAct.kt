package com.ss.lloydsbanktest.view

import MyViewModelFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ss.lloydsbanktest.MyApplication
import com.ss.lloydsbanktest.R
import com.ss.lloydsbanktest.view.adapters.BooksAdapter
import com.ss.lloydsbanktest.view.adapters.MOptionsAdapter
import com.ss.lloydsbanktest.viewmodel.BooksViewModel

class BooksAct : AppCompatActivity() {

    lateinit var viewModel: BooksViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        init()

    }

    fun init(){
        viewModel = ViewModelProvider(this, MyViewModelFactory(MyApplication.instance.mainRepository)).get(BooksViewModel::class.java)

        viewModel.getBooks()
        viewModel.books.observe(this, {

            println("Response "+it.toString())

            val booksAdapter = BooksAdapter(it)

            val recyclerView: RecyclerView = findViewById(R.id.booksRecyView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = booksAdapter
        })
    }
}