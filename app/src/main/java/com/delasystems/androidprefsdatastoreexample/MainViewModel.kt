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
package com.delasystems.androidprefsdatastoreexample

import android.app.Application
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.delasystems.androidprefsdatastoreexample.data.MyPreferences
import com.delasystems.androidprefsdatastoreexample.data.MyPrefs
import com.delasystems.androidprefsdatastoreexample.data.PrefsStoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val repository = PrefsStoreRepository(getApplication<Application>().applicationContext)

    private val _statePrefs = mutableStateOf(
        MyPreferences(
            i_am_learning = MyPrefs.Learning.default,
            favorite_color = MyPrefs.Color.default,
            favorite_number = MyPrefs.Number.default
        )
    )
    val statePrefs: State<MyPreferences>
        get() = _statePrefs


    fun observeMyPreferensesWithFlow() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getMyPreferences().collect { prefs ->
                Log.v("RHAW", "collected prefs=${prefs}")
                _statePrefs.value = _statePrefs.value.copy(
                    i_am_learning = prefs.i_am_learning,
                    favorite_color =  prefs.favorite_color,
                    favorite_number = prefs.favorite_number
                )
            }
        }
    }

    fun saveLearningPref(learning: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.setIAmLearning(learning)
        }
    }

    fun saveColorPref(color: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.setFavoriteColor(color)
        }
    }

    fun saveNumberPref(number: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.setFavoriteNumber(number)
        }
    }

    fun resetDefaultPrefs() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.setDefaults()
        }
    }
}