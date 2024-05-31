package com.ss.lloydsbankpoc.data.api

import com.ss.lloydsbankpoc.common.Constants
import com.ss.lloydsbankpoc.data.models.api_models.Books
import com.ss.lloydsbankpoc.data.models.api_models.Spells
import com.ss.lloydsbankpoc.data.models.api_models.Weasley
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET(Constants.BOOKS_URL)
    suspend fun getBooks() : Response<List<Books>>

    @GET(Constants.SPELLS_URL)
    suspend fun getSpells() : Response<List<Spells>>

    @GET(Constants.WEASLEY_URL)
    suspend fun getWeasley() : Response<List<Weasley>>

}