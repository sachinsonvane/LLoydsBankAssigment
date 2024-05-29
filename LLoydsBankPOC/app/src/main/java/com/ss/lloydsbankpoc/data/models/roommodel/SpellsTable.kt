package com.ss.lloydsbankpoc.data.models.roommodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ss.lloydsbankpoc.data.models.roommodel.TableNames.SPELLS_TABLE

@Entity(tableName = SPELLS_TABLE)
data class SpellsTable(
    @ColumnInfo(name = "spell") val spell: String,
    @ColumnInfo(name = "use") val use: String,
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}