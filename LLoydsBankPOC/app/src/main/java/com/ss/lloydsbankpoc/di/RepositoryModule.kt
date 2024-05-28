package com.ss.lloydsbankpoc.di

import com.ss.lloydsbankpoc.data.api.ApiService
import com.ss.lloydsbankpoc.data.db.BooksDao
import com.ss.lloydsbankpoc.data.db.SpellsDao
import com.ss.lloydsbankpoc.data.db.WeasleyDao
import com.ss.lloydsbankpoc.data.repository.BooksRepository
import com.ss.lloydsbankpoc.data.repository.SpellsRepository
import com.ss.lloydsbankpoc.data.repository.WeasleyRepository
import com.ss.lloydsbankpoc.domain.IBooksRepository
import com.ss.lloydsbankpoc.domain.ISpellsRepository
import com.ss.lloydsbankpoc.domain.IWeasleyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideBooksRepo(booksDao: BooksDao, apiService: ApiService): IBooksRepository =
        BooksRepository(booksDao = booksDao, apiService = apiService)

    @Provides
    @Singleton
    fun provideWeasleyRepo(weasleyDao: WeasleyDao, apiService: ApiService): IWeasleyRepository =
        WeasleyRepository(weasleyDao = weasleyDao, apiService = apiService)


    @Provides
    @Singleton
    fun provideSpellsRepo(spellsDao: SpellsDao, apiService: ApiService): ISpellsRepository =
        SpellsRepository(spellsDao = spellsDao, apiService = apiService)
}