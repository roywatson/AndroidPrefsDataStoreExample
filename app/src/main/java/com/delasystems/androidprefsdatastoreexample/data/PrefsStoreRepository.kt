package com.delasystems.androidprefsdatastoreexample.data

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class PrefsStoreRepository(
    private val context: Context
) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("myPrefs")

    val preferencesFlow: Flow<Preferences> = context.dataStore.data.catch {
        Log.v("RHAW", "flow error")
    }

    suspend fun getMyPreferences(): Flow<MyPreferences> =  preferencesFlow.map { prefs ->
        Log.v("RHAW", "map")
        MyPreferences(
            prefs[MyPrefs.Learning.key] ?: MyPrefs.Learning.default,
            prefs[MyPrefs.Color.key] ?: MyPrefs.Color.default,
            prefs[MyPrefs.Number.key] ?: MyPrefs.Number.default)
    }

    suspend fun setIAmLearning(learning: Boolean) {
        try {
            context.dataStore.edit { prefs ->
                prefs[MyPrefs.Learning.key] = learning
            }
        } catch(ex: Exception) {
            Log.v("RHAW", "edit exception")
        }
    }

    suspend fun setFavoriteColor(color: String) {
        context.dataStore.edit { prefs ->
            prefs[MyPrefs.Color.key] = color
        }
    }

    suspend fun setFavoriteNumber(number: Int) {
        context.dataStore.edit { prefs ->
            prefs[MyPrefs.Number.key] = number
        }
    }

    suspend fun setPrefField(pref: MyPrefs<Any>) {
        context.dataStore.edit { prefs ->
            prefs[pref.key] = pref.value
        }
    }

    suspend fun setDefaults() {
        context.dataStore.edit { prefs ->
            prefs[MyPrefs.Learning.key] = MyPrefs.Learning.default
            prefs[MyPrefs.Color.key] = MyPrefs.Color.default
            prefs[MyPrefs.Number.key] = MyPrefs.Number.default
        }
    }

}