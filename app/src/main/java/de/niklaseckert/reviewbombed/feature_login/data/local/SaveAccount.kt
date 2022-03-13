package de.niklaseckert.reviewbombed.feature_login.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class SaveAccount(
    private val context: Context
) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

        val ACCOUNT_ID = longPreferencesKey("ACCOUNT_ID")
        val ACCOUNT = stringPreferencesKey("ACCOUNT")
    }

    suspend fun getAccountId(): Long = context.dataStore.data.map { settings ->
        settings[ACCOUNT_ID] ?: -1
    }.first()

    suspend fun getAccountCredentials(): String = context.dataStore.data.map { settings ->
        settings[ACCOUNT] ?: ""
    }.first()

    suspend fun setAccountId(accountId: Long) {
        context.dataStore.edit { settings ->
            settings[ACCOUNT_ID] = accountId
        }
    }

    suspend fun setAccountCredentials(credentials: String) {
        context.dataStore.edit { settings ->
            settings[ACCOUNT] = credentials
        }
    }
}