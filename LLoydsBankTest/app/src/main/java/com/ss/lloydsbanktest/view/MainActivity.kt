package com.ss.lloydsbanktest.view

import MainActivityViewModel
import MyViewModelFactory
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ss.lloydsbanktest.MyApplication
import com.ss.lloydsbanktest.R

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, MyViewModelFactory(MyApplication.instance.mainRepository)).get(MainActivityViewModel::class.java)

        viewModel.getMainOptions()
        viewModel.mainOptions.observe(this, {

            println("Response mainOptions "+it.toString())

           /* val intent = Intent(this@MainActivity,SpellsAct::class.java)
            startActivity(intent)*/

        })



    }
}