package com.ss.lloydsbanktest.view

import MyViewModelFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ss.lloydsbanktest.MyApplication
import com.ss.lloydsbanktest.R
import com.ss.lloydsbanktest.viewmodel.BooksViewModel
import com.ss.lloydsbanktest.viewmodel.SpellsActViewModel

class SpellsAct : AppCompatActivity() {

    lateinit var viewModel: SpellsActViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spells)

        init()
    }

    fun init(){
        viewModel = ViewModelProvider(this, MyViewModelFactory(MyApplication.instance.mainRepository)).get(SpellsActViewModel::class.java)

        viewModel.getSpells()
        viewModel.spells.observe(this, {

            println("Response SpellsAct "+it.toString())
        })
    }
}