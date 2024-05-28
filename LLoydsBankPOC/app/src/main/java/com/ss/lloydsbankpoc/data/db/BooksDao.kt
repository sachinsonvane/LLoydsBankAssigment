package com.ss.lloydsbankpoc.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ss.lloydsbankpoc.data.models.roommodel.BooksTable
import kotlinx.coroutines.flow.Flow

@Dao
interface BooksDao {

    @Query("SELECT * FROM BOOKS_TABLE")
    fun getAllBooks(): Flow<List<BooksTable>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(books: List<BooksTable>)
}