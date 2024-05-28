package com.ss.lloydsbankpoc.di

import android.content.Context
import com.ss.lloydsbankpoc.common.PreferenceDataStoreHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun providePreferenceDataStore(@ApplicationContext context: Context): PreferenceDataStoreHelper {
        return PreferenceDataStoreHelper(context)
    }

}