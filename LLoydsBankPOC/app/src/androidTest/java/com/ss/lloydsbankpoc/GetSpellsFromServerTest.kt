package com.ss.lloydsbankpoc

import com.ss.lloydsbankpoc.data.repository.SpellsRepository
import com.ss.lloydsbankpoc.domain.usecases.SpellsDataUseCase
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
class GetSpellsFromServerTest  {

    lateinit var spellsRepository: SpellsRepository

    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        //onError("Exception handled: ${throwable.localizedMessage}")
    }

    @Before
    fun setup() {

    }

    @Test
    fun getSpellsList() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {

            val sellsDataUseCase = SpellsDataUseCase(spellsRepository = spellsRepository)
            var data = sellsDataUseCase.invoke()
            withContext(Dispatchers.Main) {

                data.map {
                    assert(it.size!=null)
                }
            }
        }
    }
}