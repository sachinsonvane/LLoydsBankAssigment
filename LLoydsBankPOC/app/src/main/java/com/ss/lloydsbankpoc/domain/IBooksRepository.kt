package com.ss.lloydsbankpoc.domain

import com.ss.lloydsbankpoc.common.ResultWrapper
import com.ss.lloydsbankpoc.data.models.api_models.Books
import com.ss.lloydsbankpoc.data.models.roommodel.BooksTable
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface IBooksRepository {

    suspend fun refreshBooks()
    val allBooks: Flow<List<BooksTable>>
    suspend fun getBooksFromServer(): ResultWrapper<Response<Books>>

//    suspend fun refreshSpells()
//    val allSpells: Flow<List<SpellsTable>>
//    suspend fun getSpellsFromServer(): ResultWrapper<Response<Spells>>
//
//    suspend fun refreshWeasley()
//    val allWeasley: Flow<List<SpellsTable>>
//    suspend fun getWeasleyFromServer(): ResultWrapper<Response<Weasley>>

}