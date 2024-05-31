package com.ss.lloydsbankpoc.common

import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object Constants {
    const val BASE_URL = "https://potterapi-fedeperin.vercel.app/"
    const val BOOKS_URL = "en/books"
    const val SPELLS_URL = "es/spells"
    const val WEASLEY_URL = "es/characters?search=Weasley"
    const val APP_LOGS_TAG = "lloydsbankpoc";
    const val IS_LOGS_ENABLE = true
}

object Route {
    const val BOOKS_SCREEN = "BOOKS_SCREEN"
    const val SPELLS_SCREEN = "SPELLS_SCREEN"
    const val WEASLEY_SCREEN = "WEASLEY_SCREEN"
}

object PreferenceDataStoreConstants {
    val ACCESS_TOKEN_KEY = stringPreferencesKey("ACCESS_TOKEN_KEY")
    val REFRESH_TOKEN = stringPreferencesKey("REFRESH_TOKEN")
    val INT_KEY = intPreferencesKey("INT_KEY")
    val LONG_KEY = longPreferencesKey("LONG_KEY")
}
