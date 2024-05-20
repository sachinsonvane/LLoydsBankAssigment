package com.ss.lloydsbanktest.viewmodel

import MainRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ss.lloydsbanktest.model.Books
import com.ss.lloydsbanktest.model.Spells
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SpellsActViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val spells = MutableLiveData<List<Spells>>()

    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()

    fun getSpells() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = mainRepository.getSpells()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    println(" response : "+response.body().toString())
                    spells.postValue(response.body())
                    loading.value = false
                } else {
                    println(" response error : "+response.message().toString())
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }

    private fun onError(message: String) {

    }

    override fun onCleared() {
        super.onCleared()

    }
}