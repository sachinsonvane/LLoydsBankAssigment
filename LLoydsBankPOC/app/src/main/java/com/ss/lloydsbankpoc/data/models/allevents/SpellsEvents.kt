package com.ss.lloydsbankpoc.data.models.allevents

sealed class SpellsEvents {
    data class ShowToastMessage(val type: String) : SpellsEvents()
    data object GetAllSpells : SpellsEvents()
}