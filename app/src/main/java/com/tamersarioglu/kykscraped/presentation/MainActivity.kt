package com.tamersarioglu.kykscraped.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.tamersarioglu.kykscraped.presentation.menu.MenuScreen
import com.tamersarioglu.kykscraped.presentation.menu.MenuViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "MainActivity onCreate started")
        setContent {
            // Material Design 3 theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                // Use hiltViewModel to get a ViewModel instance managed by Hilt
                val viewModel: MenuViewModel = hiltViewModel()
                Log.d(TAG, "MenuViewModel initialized")

                // Set the menu screen as the main content
                MenuScreen(viewModel = viewModel)
            }
        }
    }
}