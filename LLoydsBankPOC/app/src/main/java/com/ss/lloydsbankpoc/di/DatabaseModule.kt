package com.ss.lloydsbankpoc.di

import android.content.Context
import androidx.room.Room
import com.ss.lloydsbankpoc.data.db.AppDatabase
import com.ss.lloydsbankpoc.data.db.BooksDao
import com.ss.lloydsbankpoc.data.db.SpellsDao
import com.ss.lloydsbankpoc.data.db.WeasleyDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "APP_DATABASE"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideBooksDao(appDatabase: AppDatabase): BooksDao = appDatabase.bookDao()

    @Provides
    @Singleton
    fun provideSpellsDao(appDatabase: AppDatabase): SpellsDao = appDatabase.spellsDao()

    @Provides
    @Singleton
    fun provideWeasleyDao(appDatabase: AppDatabase): WeasleyDao = appDatabase.weasleyDao()
}