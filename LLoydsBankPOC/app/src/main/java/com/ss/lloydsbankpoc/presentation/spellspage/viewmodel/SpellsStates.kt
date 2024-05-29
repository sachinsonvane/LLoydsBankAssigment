package com.ss.lloydsbankpoc.presentation.spellspage.viewmodel

import com.ss.lloydsbankpoc.data.models.roommodel.SpellsTable

data class SpellsStates(
    val allSpellsData: List<SpellsTable> = listOf()
)