package com.example.week8.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.week8.screens.TodoScreen
import com.example.week8.ui.theme.Week8Theme
import com.example.week8.viewmodel.TodoViewModel

class MainActivity : ComponentActivity() {
    private val todoViewModel: TodoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Week8Theme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    TodoScreen(todoViewModel.todos)
                }
            }
        }
    }
}
