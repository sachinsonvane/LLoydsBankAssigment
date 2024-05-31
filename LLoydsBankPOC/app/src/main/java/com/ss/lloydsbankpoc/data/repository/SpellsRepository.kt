package com.ss.lloydsbankpoc.data.repository

import android.util.Log
import com.ss.lloydsbankpoc.App
import com.ss.lloydsbankpoc.R
import com.ss.lloydsbankpoc.common.ResultWrapper
import com.ss.lloydsbankpoc.common.showLogs
import com.ss.lloydsbankpoc.common.showMessage
import com.ss.lloydsbankpoc.data.api.ApiService
import com.ss.lloydsbankpoc.data.db.SpellsDao
import com.ss.lloydsbankpoc.data.db.WeasleyDao
import com.ss.lloydsbankpoc.data.models.api_models.Spells
import com.ss.lloydsbankpoc.data.models.roommodel.SpellsTable
import com.ss.lloydsbankpoc.data.models.roommodel.WeasleyTable
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
        try {
            val response = apiService.getSpells()
            if (response.isSuccessful) {
                if (response.code() == 200) {
                    val spellsData = response.body()
                    val spellsArr = spellsData!!.map { spells ->
                        SpellsTable(
                            spell = spells.spell,
                            use = spells.use,
                        )
                    }
                    if (spellsArr != null) {
                        spellsDao.insertAll(spellsArr)
                    }else{
                        showMessage(App.instance.resources.getResourceName(R.string.data_not_found_str))
                    }
                }else{
                    showMessage(App.instance.resources.getResourceName(R.string.api_response_null_str))
                }
            }else{
                showMessage(App.instance.resources.getResourceName(R.string.api_network_error_str))
            }
        } catch (e: Exception) {
            showLogs(e.message.toString())
        }
    }
}
