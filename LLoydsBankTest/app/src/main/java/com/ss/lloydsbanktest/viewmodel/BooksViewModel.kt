package com.ss.lloydsbanktest.viewmodel

import MainRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ss.lloydsbanktest.model.Books
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BooksViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val books = MutableLiveData<List<Books>>()

    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()

    fun getBooks() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = mainRepository.getBooks()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    println(" response : "+response.body().toString())
                    books.postValue(response.body())
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