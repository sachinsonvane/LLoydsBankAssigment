package com.ss.lloydsbankpoc.presentation.bookspage.viewmodel

sealed class BooksEvents {
    data class ShowToastMessage(val type: String) : BooksEvents()
    data object GetAllBooks : BooksEvents()
}