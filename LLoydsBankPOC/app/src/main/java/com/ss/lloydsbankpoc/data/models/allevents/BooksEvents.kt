package com.ss.lloydsbankpoc.data.models.allevents

sealed class BooksEvents {
    data class ShowToastMessage(val type: String) : BooksEvents()
    data object GetAllBooks : BooksEvents()
}