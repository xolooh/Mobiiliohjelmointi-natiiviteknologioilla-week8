package com.example.week8.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week8.Model.Todo
import com.example.week8.api.TodosApi
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class TodoViewModel: ViewModel() {
    var todos = mutableStateListOf<Todo>()
        private set

    init {
        getTodosList()
    }

    private fun getTodosList() {
        viewModelScope.launch {
            try {
                val todosApi = TodosApi.getInstance()
                todos.clear()
                todos.addAll(todosApi.getTodos())
            } catch (e: Exception) {
                Log.d("TODOVIEWMODEL", e.message.toString())
            }
        }
    }
}