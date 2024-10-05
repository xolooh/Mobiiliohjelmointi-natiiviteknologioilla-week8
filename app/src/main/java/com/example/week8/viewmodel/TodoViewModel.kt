package com.example.week8.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week8.Model.Todo
import com.example.week8.api.TodosApi
import kotlinx.coroutines.launch

class TodoViewModel: ViewModel() {
    var todos = mutableListOf<Todo>()
    private set

    init {
getTodosList()
    }

    private fun getTodosList() {
        viewModelScope.launch {
            var todosApi: TodosApi? = null
            try {
                todosApi = TodosApi!!.getInstance()
                todos.clear()
                todos.addAll(todosApi.getTodos())
            } catch (e: Exception) {
                Log.d("TODOVIEWMODEL", e.message.toString())
            }
        }
    }
}