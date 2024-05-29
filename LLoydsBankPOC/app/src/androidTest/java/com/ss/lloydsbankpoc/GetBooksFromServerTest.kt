package com.ss.lloydsbankpoc

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.junit.Before
import org.junit.Test
import javax.inject.Singleton
//
@Singleton
class GetBooksFromServerTest  {


    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        //onError("Exception handled: ${throwable.localizedMessage}")
    }

    @Before
    fun setup() {

    }

    @Test
    fun test() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
           // val response = booksRepository.refreshBooks()

            withContext(Dispatchers.Main) {

            }
        }
    }
}

