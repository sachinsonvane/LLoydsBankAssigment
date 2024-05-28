package com.ss.lloydsbankpoc.data.repository

import com.ss.lloydsbankpoc.common.ResultWrapper
import com.ss.lloydsbankpoc.data.api.ApiService
import com.ss.lloydsbankpoc.data.db.WeasleyDao
import com.ss.lloydsbankpoc.data.models.api_models.Weasley
import com.ss.lloydsbankpoc.data.models.roommodel.WeasleyTable
import com.ss.lloydsbankpoc.domain.IWeasleyRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeasleyRepository @Inject constructor(private val weasleyDao:  WeasleyDao, val apiService: ApiService) : IWeasleyRepository {

    override val allWeasley: Flow<List<WeasleyTable>> = weasleyDao.getAllWeasley()
    override suspend fun getWeasleyFromServer(): ResultWrapper<Response<Weasley>> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshWeasley() {
        TODO("Not yet implemented")
    }

    /*override suspend fun refreshUsers() {
        try {
            val response = apiService.getAllUsers()
            if (response.isSuccessful) {
                if (response.code() == 200) {
                    val users = response.body()?.data?.map { user ->
                        UserTable(
                            id = user.id!!,
                            email = user.email!!,
                            firstName = user.firstName!!,
                            lastName = user.lastName!!,
                            avatar = user.avatar!!
                        )
                    }
                    if (users != null) {
                        userDao.insertAll(users)
                    } // Insert the mapped data into the database
                }
            }
        } catch (e: Exception) {
            Log.e("USER_API", e.message.toString())
        }
    }*/
}