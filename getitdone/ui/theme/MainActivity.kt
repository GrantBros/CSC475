package com.example.getitdone.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import com.example.getitdone.ui.viewModel.GIDViewModel
import com.example.getitdone.data.*


class MainActivity : ComponentActivity() {
    private lateinit var viewModel: GIDViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val dao = GIDDatabase.getDatabase(applicationContext).doneDao()
        val repository = GIDRepository(dao)
        viewModel = GIDViewModel(repository)
        setContent {
            MaterialTheme(colorScheme = lightColorScheme()) {
                AppNavHost(viewModel)
            }
        }
    }
}