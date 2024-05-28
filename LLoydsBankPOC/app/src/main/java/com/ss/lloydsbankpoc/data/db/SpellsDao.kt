package com.ss.lloydsbankpoc.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ss.lloydsbankpoc.data.models.roommodel.SpellsTable
import kotlinx.coroutines.flow.Flow

@Dao
interface SpellsDao {

    @Query("SELECT * FROM SPELLS_TABLE")
    fun getAllSpells(): Flow<List<SpellsTable>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(spells: List<SpellsTable>)
}