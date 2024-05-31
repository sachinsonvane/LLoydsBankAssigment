package com.ss.lloydsbankpoc.domain.usecases

import com.ss.lloydsbankpoc.data.models.roommodel.BooksTable
import com.ss.lloydsbankpoc.data.models.roommodel.SpellsTable
import com.ss.lloydsbankpoc.data.repository.BooksRepository
import com.ss.lloydsbankpoc.data.repository.SpellsRepository
import kotlinx.coroutines.flow.Flow

class SpellsDataUseCase(spellsRepository: SpellsRepository) {

    private val allSpells = spellsRepository.allSpells
    operator fun invoke(): Flow<List<SpellsTable>> {
        return  allSpells
    }
}