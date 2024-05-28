package com.ss.lloydsbankpoc.data.repository

import com.ss.lloydsbankpoc.common.ResultWrapper
import com.ss.lloydsbankpoc.data.api.ApiService
import com.ss.lloydsbankpoc.data.db.SpellsDao
import com.ss.lloydsbankpoc.data.db.WeasleyDao
import com.ss.lloydsbankpoc.data.models.api_models.Spells
import com.ss.lloydsbankpoc.data.models.roommodel.SpellsTable
import com.ss.lloydsbankpoc.domain.ISpellsRepository
import com.ss.lloydsbankpoc.domain.IWeasleyRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SpellsRepository @Inject constructor(private val spellsDao: SpellsDao, val apiService: ApiService) :ISpellsRepository {


    override val allSpells: Flow<List<SpellsTable>> = spellsDao.getAllSpells()
    override suspend fun getSpellsFromServer(): ResultWrapper<Response<Spells>> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshSpells() {
        TODO("Not yet implemented")
    }
}
