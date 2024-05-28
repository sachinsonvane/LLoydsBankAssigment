package com.ss.lloydsbankpoc.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ss.lloydsbankpoc.data.models.roommodel.BooksTable
import com.ss.lloydsbankpoc.data.models.roommodel.SpellsTable
import com.ss.lloydsbankpoc.data.models.roommodel.WeasleyTable


@Database(
    entities = [BooksTable::class, SpellsTable::class,WeasleyTable::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BooksDao
    abstract fun spellsDao(): SpellsDao
    abstract fun weasleyDao(): WeasleyDao
}