package com.ss.lloydsbanktest.view

import MainActivityViewModel
import MainRepository
import MyViewModelFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ss.lloydsbanktest.R

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofitService = RetrofitService.getInstance()
        val mainRepository = MainRepository(retrofitService)
        viewModel = ViewModelProvider(this, MyViewModelFactory(mainRepository)).get(MainActivityViewModel::class.java)

        viewModel.getMainOptions()
        viewModel.mainOptions.observe(this, {

            println("Response "+it.toString())
        })

    }
}