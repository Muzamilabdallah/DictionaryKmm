package com.muzamil.dictionarykmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.muzamil.dictionarykmm.android.ui.component.home

import com.muzamil.dictionarykmm.android.ui.viewmodel.AndroidDictionaryViewModel

import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel: AndroidDictionaryViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    home(viewModel )
                }
            }
        }
    }
}



@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {

    }
}
