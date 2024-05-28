package com.ss.lloydsbankpoc.data.models.roommodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ss.lloydsbankpoc.data.models.roommodel.TableNames.BOOKS_TABLE

@Entity(tableName = BOOKS_TABLE)
data class BooksTable(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "originalTitle") val originalTitle: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "cover") val cover: String
)
