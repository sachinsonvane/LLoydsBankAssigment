package com.ss.lloydsbankpoc.domain
import com.ss.lloydsbankpoc.common.ResultWrapper
import com.ss.lloydsbankpoc.data.models.api_models.Weasley
import com.ss.lloydsbankpoc.data.models.roommodel.WeasleyTable
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface IWeasleyRepository {

    suspend fun refreshWeasley()
    val allWeasley: Flow<List<WeasleyTable>>
    suspend fun getWeasleyFromServer(): ResultWrapper<Response<Weasley>>

}