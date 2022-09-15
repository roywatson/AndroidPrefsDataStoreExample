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