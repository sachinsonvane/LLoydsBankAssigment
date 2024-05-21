package com.ss.lloydsbanktest.view

import MyViewModelFactory
import WeasleyViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ss.lloydsbanktest.MyApplication
import com.ss.lloydsbanktest.R
import com.ss.lloydsbanktest.view.adapters.BooksAdapter
import com.ss.lloydsbanktest.view.adapters.WeasleyAdapter
import com.ss.lloydsbanktest.viewmodel.SpellsActViewModel

class WeasleyAct : AppCompatActivity() {

    lateinit var viewModel: WeasleyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weasley)

        init()
    }

    fun init(){
        viewModel = ViewModelProvider(this, MyViewModelFactory(MyApplication.instance.mainRepository)).get(WeasleyViewModel::class.java)

        viewModel.getWeasley()
        viewModel.weasley.observe(this, {

            println("Response WeasleyAct "+it.toString())

            val weasleyAdapter = WeasleyAdapter(it)

            val recyclerView: RecyclerView = findViewById(R.id.weasleyRecyView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = weasleyAdapter
        })
    }
}