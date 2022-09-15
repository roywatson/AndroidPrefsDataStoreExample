package com.delasystems.androidprefsdatastoreexample.data

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

data class MyPreferences(
    val i_am_learning: Boolean,
    val favorite_color: String,
    val favorite_number: Int
)

sealed class MyPrefs<T>( val key: Preferences.Key<T>, val default: T, var value: T) {
    object Learning : MyPrefs<Boolean>(key = booleanPreferencesKey("i_am_learning"), default = false, value = false)
    object Color : MyPrefs<String>(key = stringPreferencesKey("color"), default = "", value = "")
    object Number : MyPrefs<Int>(intPreferencesKey("number"), default = -1, value = -1)
}