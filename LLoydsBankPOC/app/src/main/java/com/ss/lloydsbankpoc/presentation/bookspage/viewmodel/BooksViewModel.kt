package com.ss.lloydsbankpoc.presentation.bookspage.viewmodel

import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ss.lloydsbankpoc.App
import com.ss.lloydsbankpoc.R
import com.ss.lloydsbankpoc.common.showMessage
import com.ss.lloydsbankpoc.data.models.allevents.BooksEvents
import com.ss.lloydsbankpoc.data.models.allstates.BooksState
import com.ss.lloydsbankpoc.data.repository.BooksRepository
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
               showMessage(App.instance.resources.getResourceName(R.string.error_str))
            }
        }
    }

    private suspend fun getAllBooks() {
        booksRepository.allBooks.collect {
            _state.value = _state.value.copy(allBooksData = it)
        }
    }
}