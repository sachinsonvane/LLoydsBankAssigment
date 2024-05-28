package com.ss.lloydsbankpoc.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ss.lloydsbankpoc.data.models.roommodel.WeasleyTable
import kotlinx.coroutines.flow.Flow

@Dao
interface WeasleyDao {

    @Query("SELECT * FROM WEASLEY_TABLE")
    fun getAllWeasley(): Flow<List<WeasleyTable>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(weasley: List<WeasleyTable>)
}