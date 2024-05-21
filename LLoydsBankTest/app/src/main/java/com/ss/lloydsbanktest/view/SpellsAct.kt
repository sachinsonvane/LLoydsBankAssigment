package com.ss.lloydsbanktest.view

import MyViewModelFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ss.lloydsbanktest.MyApplication
import com.ss.lloydsbanktest.R
import com.ss.lloydsbanktest.databinding.ActivitySpellsBinding
import com.ss.lloydsbanktest.view.adapters.SpellsAdapter
import com.ss.lloydsbanktest.view.adapters.WeasleyAdapter
import com.ss.lloydsbanktest.viewmodel.BooksViewModel
import com.ss.lloydsbanktest.viewmodel.SpellsActViewModel

class SpellsAct : AppCompatActivity() {

    lateinit var viewModel: SpellsActViewModel
    lateinit var binding: ActivitySpellsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_spells)

        init()
    }

    fun init(){

        binding = DataBindingUtil.setContentView(this,R.layout.activity_spells)

        viewModel = ViewModelProvider(this, MyViewModelFactory(MyApplication.instance.mainRepository)).get(SpellsActViewModel::class.java)

        viewModel.getSpells()
        viewModel.spells.observe(this, {

            println("Response SpellsAct "+it.toString())

            val spellsAdapter = SpellsAdapter(it)
            binding.spellsRecyView.layoutManager = LinearLayoutManager(this)
            binding.spellsRecyView.adapter = spellsAdapter
        })
    }
}