package com.ss.lloydsbanktest.view

import MyViewModelFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ss.lloydsbanktest.MyApplication
import com.ss.lloydsbanktest.R
import com.ss.lloydsbanktest.databinding.ActivityBooksBinding
import com.ss.lloydsbanktest.view.adapters.BooksAdapter
import com.ss.lloydsbanktest.viewmodel.BooksViewModel

class BooksAct : AppCompatActivity() {

    lateinit var viewModel: BooksViewModel
    lateinit var binding: ActivityBooksBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_books)

        init()
    }

    fun init(){

        binding = DataBindingUtil.setContentView(this,R.layout.activity_books)

        viewModel = ViewModelProvider(this, MyViewModelFactory(MyApplication.instance.mainRepository)).get(BooksViewModel::class.java)

        viewModel.getBooks()
        viewModel.books.observe(this, {

            println("Response "+it.toString())
            val booksAdapter = BooksAdapter(this,it)

            binding.booksRecyView.layoutManager = LinearLayoutManager(this)
            binding.booksRecyView.adapter = booksAdapter
        })
    }
}