package com.delasystems.androidprefsdatastoreexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.delasystems.androidprefsdatastoreexample.data.MyPreferences
import com.delasystems.androidprefsdatastoreexample.ui.misc.Attribution
import com.delasystems.androidprefsdatastoreexample.ui.theme.AndroidPrefsDataStoreExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrefsDataStoreApp()
        }
    }
}

@Composable
private fun PrefsDataStoreApp() {
    val viewModel: MainViewModel = viewModel()
    PrefsDatastoreMainScreen(
        modifier = Modifier.fillMaxSize(),
        viewModel,
        state = viewModel.statePrefs.value
    )
}

@Composable
private fun PrefsDatastoreMainScreen(
    modifier: Modifier,
    viewModel: MainViewModel,
    state: MyPreferences
) {
    AndroidPrefsDataStoreExampleTheme {
        LaunchedEffect(key1 = Unit, block = {
            viewModel.observeMyPreferensesWithFlow()
        })
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentHeight()
                    .padding(5.dp)
            ) {
                Attribution()
                 Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Set Learning = ",
                        fontSize = 18.sp,
                    )
                    Button(
                        content = { Text("true", fontSize = 18.sp) },
                        onClick = { viewModel.saveLearningPref(true) },
                        modifier = Modifier.padding(start = 5.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
                    )
                    Button(
                        content = { Text("false", fontSize = 18.sp) },
                        onClick = { viewModel.saveLearningPref(false) },
                        modifier = Modifier.padding(start = 0.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Set Color = ",
                        fontSize = 18.sp,
                    )
                    Button(
                        content = { Text("green", fontSize = 18.sp) },
                        onClick = { viewModel.saveColorPref("green") },
                        modifier = Modifier.padding(start = 5.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
                    )
                    Button(
                        content = { Text("blue", fontSize = 18.sp) },
                        onClick = { viewModel.saveColorPref("blue") },
                        modifier = Modifier.padding(start = 0.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Set Number = ",
                        fontSize = 18.sp,
                    )
                    Button(
                        content = { Text("43", fontSize = 18.sp) },
                        onClick = { viewModel.saveNumberPref(43) },
                        modifier = Modifier.padding(start = 5.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
                    )
                    Button(
                        content = { Text("86", fontSize = 18.sp) },
                        onClick = { viewModel.saveNumberPref(86) },
                        modifier = Modifier.padding(start = 0.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
                    )
                }

                Button(
                    content = { Text("Reset Default Values", fontSize = 18.sp) },
                    onClick = { viewModel.resetDefaultPrefs() },
                    modifier = Modifier.padding(start = 0.dp, top = 5.dp, end = 0.dp, bottom = 5.dp)
                )

                Row(
                    modifier = Modifier.padding(start = 0.dp, top = 5.dp, end = 0.dp, bottom = 5.dp)
                ) {
                    Text(
                        text = "i_am_learning = ",
                        fontSize = 20.sp,
                    )
                    Text(
                        text = state.i_am_learning.toString(),
                        fontSize = 20.sp,
                    )
                }
                Row(
                    modifier = Modifier.padding(start = 0.dp, top = 5.dp, end = 0.dp, bottom = 5.dp)
                ) {
                    Text(
                        text = "Favorite Color = ",
                        fontSize = 20.sp,
                    )
                    Text(
                        text = state.favorite_color,
                        fontSize = 20.sp,
                    )
                }
                Row(
                    modifier = Modifier.padding(start = 0.dp, top = 5.dp, end = 0.dp, bottom = 5.dp)
                ) {
                    Text(
                        text = "Favorite Number = ",
                        fontSize = 20.sp,
                    )
                    Text(
                        state.favorite_number.toString(),
                        fontSize = 20.sp,
                    )
                }
            }
        }
    }
}
