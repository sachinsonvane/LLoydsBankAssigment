
package com.ss.lloydsbanktest
import MainRepository
import RetrofitService
import android.app.Application

class MyApplication: Application() {

    lateinit var retrofitService:RetrofitService
    lateinit var mainRepository:MainRepository
    override fun onCreate() {
        super.onCreate()
        init()
    }

    fun init(){
        instance = this
        retrofitService = RetrofitService.getInstance()
        mainRepository = MainRepository(retrofitService)
    }

    companion object {
        lateinit var instance: MyApplication
            private set
    }
}