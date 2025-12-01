package com.example.getitdone.ui.viewModel

import androidx.compose.foundation.rememberPlatformOverscrollFactory
import com.example.getitdone.data.*
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow


class GIDViewModel(private val repository: GIDRepository) : ViewModel() {

    private val _tasker = MutableStateFlow<List<GetItDone>>(emptyList())
    val tasker: StateFlow<List<GetItDone>> = _tasker.asStateFlow()

    init {
        viewModelScope.launch {
            repository.allTodo.collect { todos -> _tasker.value = todos }
        }
    }
fun updateTodo(todo: GetItDone) = viewModelScope.launch {
    repository.update(todo)
}
    fun deleteTodo(todo : GetItDone) = viewModelScope.launch {
        repository.delete(todo)
}
    fun insertTodo(todo : GetItDone) = viewModelScope.launch {
        repository.insert(todo)
    }
}