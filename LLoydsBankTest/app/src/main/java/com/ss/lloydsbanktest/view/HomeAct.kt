package com.ss.lloydsbanktest.view

import MainActivityViewModel
import MyViewModelFactory
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ss.lloydsbanktest.MyApplication
import com.ss.lloydsbanktest.R
import com.ss.lloydsbanktest.databinding.ActivityMainBinding
import com.ss.lloydsbanktest.view.adapters.MOptionsAdapter

class HomeAct : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_main)
        init()

    }

    fun init(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this, MyViewModelFactory(MyApplication.instance.mainRepository)).get(MainActivityViewModel::class.java)

        viewModel.getMainOptions()
        viewModel.mainOptions.observe(this, {

            println("Response mainOptions "+it.toString())
            val optionsAdapter = MOptionsAdapter(this,it)
            binding.moptionsRecyView.layoutManager = LinearLayoutManager(this)
            binding.moptionsRecyView.adapter = optionsAdapter

        })
    }

    public fun goToSpellAct(){
        val intent = Intent(this@HomeAct,SpellsAct::class.java)
        startActivity(intent)
    }
    public fun goToBooksAct(){
        val intent = Intent(this@HomeAct,BooksAct::class.java)
        startActivity(intent)
    }
    public fun goToWeasleyAct(){
        val intent = Intent(this@HomeAct,WeasleyAct::class.java)
        startActivity(intent)
    }
}