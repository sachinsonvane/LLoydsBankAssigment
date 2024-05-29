package com.ss.lloydsbankpoc.presentation.spellspage.viewmodel

sealed class SpellsEvents {
    data class ShowToastMessage(val type: String) : SpellsEvents()
    data object GetAllSpells : SpellsEvents()
}