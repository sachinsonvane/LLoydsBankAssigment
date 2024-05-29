package com.ss.lloydsbankpoc.data.models.roommodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ss.lloydsbankpoc.data.models.roommodel.TableNames.WEASLEY_TABLE

@Entity(tableName = WEASLEY_TABLE)
data class WeasleyTable(
    @ColumnInfo(name = "fullName") val fullName: String,
    @ColumnInfo(name = "nickname") val nickname: String,
    @ColumnInfo(name = "hogwartsHouse") val hogwartsHouse: String,
    @ColumnInfo(name = "interpretedBy") val interpretedBy: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "birthdate") val birthdate: String,
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
