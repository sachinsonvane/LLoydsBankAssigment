package com.ss.lloydsbankpoc

import com.ss.lloydsbankpoc.data.repository.BooksRepository
import com.ss.lloydsbankpoc.data.repository.WeasleyRepository
import com.ss.lloydsbankpoc.domain.usecases.BooksDataUseCase
import com.ss.lloydsbankpoc.domain.usecases.WeasleyDataUseCase
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
class GetWeasleysFromServerTest  {

    lateinit var weasleyRepository: WeasleyRepository

    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        //onError("Exception handled: ${throwable.localizedMessage}")
    }

    @Before
    fun setup() {

    }

    @Test
    fun getWeasleyList() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {

            val weasleyDataUseCase = WeasleyDataUseCase(weasleyRepository = weasleyRepository)
            var data = weasleyDataUseCase.invoke()
            withContext(Dispatchers.Main) {

                data.map {
                    assert(it.size!=null)
                }
            }
        }
    }
}