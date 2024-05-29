package com.ss.lloydsbankpoc.data.repository

import android.util.Log
import com.ss.lloydsbankpoc.common.ResultWrapper
import com.ss.lloydsbankpoc.data.api.ApiService
import com.ss.lloydsbankpoc.data.db.BooksDao
import com.ss.lloydsbankpoc.data.models.api_models.Books
import com.ss.lloydsbankpoc.data.models.roommodel.BooksTable
import com.ss.lloydsbankpoc.data.models.roommodel.SpellsTable
import com.ss.lloydsbankpoc.domain.IBooksRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BooksRepository @Inject constructor(private val booksDao: BooksDao, val apiService: ApiService) : IBooksRepository {

    override val allBooks: Flow<List<BooksTable>> = booksDao.getAllBooks()
    override suspend fun getBooksFromServer(): ResultWrapper<Response<Books>> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshBooks() {
        try {
            val response = apiService.getBooks()
            if (response.isSuccessful) {
                if (response.code() == 200) {
                    val booksData = response.body()
                    val booksArr = booksData!!.map { books ->
                        BooksTable(
                            title = books.title!!,
                            originalTitle = books.originalTitle!!,
                            description = books.description!!,
                            cover = books.cover!!,
                        )
                    }
                    if (booksArr != null) {
                        booksDao.insertAll(booksArr)
                    } // Insert the mapped data into the database
                }
            }
        } catch (e: Exception) {
            Log.e("USER_API", e.message.toString())
        }
    }
}