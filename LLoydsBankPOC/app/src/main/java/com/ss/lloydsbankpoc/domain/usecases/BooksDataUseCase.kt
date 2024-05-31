package com.ss.lloydsbankpoc.domain.usecases

import com.ss.lloydsbankpoc.data.models.roommodel.BooksTable
import com.ss.lloydsbankpoc.data.repository.BooksRepository
import kotlinx.coroutines.flow.Flow


class BooksDataUseCase(booksRepository: BooksRepository) {

    private val allBooks = booksRepository.allBooks
    operator fun invoke(): Flow<List<BooksTable>> {
        return  allBooks
    }
}