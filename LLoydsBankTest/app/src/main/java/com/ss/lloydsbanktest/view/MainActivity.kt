package com.ss.lloydsbanktest.view

import MainActivityViewModel
import MyViewModelFactory
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ss.lloydsbanktest.MyApplication
import com.ss.lloydsbanktest.R
import com.ss.lloydsbanktest.view.adapters.MOptionsAdapter

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, MyViewModelFactory(MyApplication.instance.mainRepository)).get(MainActivityViewModel::class.java)

        viewModel.getMainOptions()
        viewModel.mainOptions.observe(this, {

            println("Response mainOptions "+it.toString())

            val optionsAdapter = MOptionsAdapter(this,it)

            val recyclerView: RecyclerView = findViewById(R.id.moptionsRecyView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = optionsAdapter

        })
    }

    public fun goToSpellAct(){
        val intent = Intent(this@MainActivity,SpellsAct::class.java)
        startActivity(intent)
    }
    public fun goToBooksAct(){
        val intent = Intent(this@MainActivity,BooksAct::class.java)
        startActivity(intent)
    }
    public fun goToWeasleyAct(){
        val intent = Intent(this@MainActivity,WeasleyAct::class.java)
        startActivity(intent)
    }
}