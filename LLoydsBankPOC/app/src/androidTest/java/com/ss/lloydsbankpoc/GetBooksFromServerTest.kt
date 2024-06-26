package com.ss.lloydsbankpoc

import com.ss.lloydsbankpoc.data.repository.BooksRepository
import com.ss.lloydsbankpoc.domain.usecases.BooksDataUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.junit.Before
import org.junit.Test
import javax.inject.Singleton

@Singleton
class GetBooksFromServerTest  {

    lateinit var repository: BooksRepository

    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        //onError("Exception handled: ${throwable.localizedMessage}")
    }

    @Before
    fun setup() {

    }

    @Test
    fun getBooksList() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {

            val booksDataUseCase = BooksDataUseCase(booksRepository = repository)
            var data = booksDataUseCase.invoke()
            withContext(Dispatchers.Main) {

                data.map {
                    assert(it.size!=null)
                }
            }
        }
    }
}

