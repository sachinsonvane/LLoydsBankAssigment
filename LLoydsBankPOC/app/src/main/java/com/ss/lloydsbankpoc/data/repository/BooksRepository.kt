package com.ss.lloydsbankpoc.data.repository

import android.util.Log
import com.ss.lloydsbankpoc.App
import com.ss.lloydsbankpoc.R
import com.ss.lloydsbankpoc.common.ResultWrapper
import com.ss.lloydsbankpoc.common.showLogs
import com.ss.lloydsbankpoc.common.showMessage
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
                            title = books.title,
                            originalTitle = books.originalTitle,
                            description = books.description,
                            cover = books.cover,
                        )
                    }
                    if (booksArr != null) {
                        booksDao.insertAll(booksArr)
                    }else{
                        showMessage(App.instance.resources.getResourceName(R.string.data_not_found_str))
                    }
                }else{
                    showMessage(App.instance.resources.getResourceName(R.string.api_response_null_str))
                }
            }else{
                showMessage(App.instance.resources.getResourceName(R.string.api_network_error_str))
            }
        } catch (e: Exception) {
            showLogs(e.message.toString())
        }
    }
}