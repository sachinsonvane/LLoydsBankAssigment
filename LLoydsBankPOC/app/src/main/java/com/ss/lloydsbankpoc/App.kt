package com.ss.lloydsbankpoc

import android.app.Application
import com.ss.lloydsbankpoc.data.repository.BooksRepository
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application(){

    override fun onCreate() {
        super.onCreate()

        init()
    }

    fun init(){
        instance = this
    }

    companion object {
        lateinit var instance: App
            private set
    }
}