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

/**
 * Class to save the id, username and password of the logged in user.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class SaveAccount(

    /** Contains the application context. */
    private val context: Context
) {

    companion object {

        /** Setup Datastore to store id and credentials. */
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

        /** Key for the account id. */
        val ACCOUNT_ID = longPreferencesKey("ACCOUNT_ID")

        /** Key for the account credentials. */
        val ACCOUNT = stringPreferencesKey("ACCOUNT")
    }

    /**
     * Method to get the currently logged in account id.
     *
     * @return the currently logged in id or -1.
     */
    suspend fun getAccountId(): Long = context.dataStore.data.map { settings ->
        settings[ACCOUNT_ID] ?: -1
    }.first()

    /**
     * Method to get the currently logged in account credentials.
     *
     * @return the currently logged in credentials or "".
     */
    suspend fun getAccountCredentials(): String = context.dataStore.data.map { settings ->
        settings[ACCOUNT] ?: ""
    }.first()

    /**
     * Method to set the account id.
     *
     * @param accountId contains the new id.
     */
    suspend fun setAccountId(accountId: Long) {
        context.dataStore.edit { settings ->
            settings[ACCOUNT_ID] = accountId
        }
    }

    /**
     * Method to set the account credentials.
     *
     * @param credentials contains the new account credentials.
     */
    suspend fun setAccountCredentials(credentials: String) {
        context.dataStore.edit { settings ->
            settings[ACCOUNT] = credentials
        }
    }
}