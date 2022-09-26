/*
Copyright (C) 2022 Roy Watson

Permission is hereby granted, free of charge, to any person obtaining a copy of this
software and associated documentation files (the "Software"), to deal in the Software
without restriction, including without limitation the rights to use, copy, modify, merge,
publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons
to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies
or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
OR OTHER DEALINGS IN THE SOFTWARE.
*/
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