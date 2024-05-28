package com.ss.lloydsbankpoc.domain

import com.ss.lloydsbankpoc.common.ResultWrapper
import com.ss.lloydsbankpoc.data.models.api_models.Spells
import com.ss.lloydsbankpoc.data.models.roommodel.SpellsTable
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ISpellsRepository {

    suspend fun refreshSpells()
    val allSpells: Flow<List<SpellsTable>>
    suspend fun getSpellsFromServer(): ResultWrapper<Response<Spells>>
}