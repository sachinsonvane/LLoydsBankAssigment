package com.ss.lloydsbankpoc.presentation.bookspage.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ss.lloydsbankpoc.data.repository.BooksRepository
import com.ss.lloydsbankpoc.presentation.main.viewmodel.MainEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class BooksViewModel @Inject constructor(private val booksRepository: BooksRepository
) : ViewModel() {

    private val _state = mutableStateOf(BooksState())
    val state: State<BooksState> = _state

    val allBooks = booksRepository.allBooks

    fun onEvent(events: BooksEvents) {
        when (events) {
            is BooksEvents.GetAllBooks -> {
                viewModelScope.launch {
                    booksRepository.refreshBooks()
                    getAllBooks()
                }
            }
            is BooksEvents.ShowToastMessage -> {
                /*  if (events.type == application.getString(R.string.ocean))
                      Toast.makeText(application, "${_state.value.allOceanData}", Toast.LENGTH_SHORT)
                          .show()
                  else
                      Toast.makeText(application, "${_state.value.allWoodsData}", Toast.LENGTH_SHORT)
                          .show()*/
            }
        }
    }

    private suspend fun getAllBooks() {
        booksRepository.allBooks.collect {
            _state.value = _state.value.copy(allBooksData = it)
        }
    }
}