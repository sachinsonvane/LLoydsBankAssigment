package com.ss.lloydsbankpoc.presentation.bookspage.viewmodel

import com.ss.lloydsbankpoc.data.models.roommodel.BooksTable

 data class BooksState(
    val allBooksData: List<BooksTable> = listOf()
 )