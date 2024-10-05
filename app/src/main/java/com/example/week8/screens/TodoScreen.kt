package com.example.week8.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.week8.Model.Todo

@Composable
fun TodoScreen(todos: List<Todo>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(todos) { todo ->
            Text(text = todo.title)
            Divider()
        }
    }
}
