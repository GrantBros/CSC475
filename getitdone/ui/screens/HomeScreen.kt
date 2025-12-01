package com.example.getitdone.ui.screens

import com.example.getitdone.data.GetItDone
import com.example.getitdone.ui.viewModel.GIDViewModel
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.clickable


@Composable
fun HomeScreen(
    viewModel: GIDViewModel,
    onAdd: () -> Unit,
    onEdit: (GetItDone) -> Unit
) {
    val todos by viewModel.tasker.collectAsState(initial = emptyList())

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = onAdd) {
            Icon(Icons.Default.Add, contentDescription = "Add Task")
        }
    }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(todos) { todo ->
                TodoItem(
                    todo = todo,
                    onToggle = { viewModel.updateTodo(todo.copy(isDone = !todo.isDone)) },
                    onEdit = { onEdit(todo) },
                    onDelete = { viewModel.deleteTodo(todo) }
                )
            }
        }
    }
}

@Composable
fun TodoItem(
    todo: GetItDone,
    onToggle: () -> Unit,
    onEdit: () -> Unit,
    onDelete: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onEdit() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            RadioButton(
                selected = todo.isDone,
                onClick = onToggle
            )
            Spacer(modifier =Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = todo.title,
                    style = MaterialTheme.typography.titleMedium
                )
                if (todo.details.isNotBlank()) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = todo.details, style = MaterialTheme.typography.bodyMedium)
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            IconButton(onClick = onEdit) {
                Icon(Icons.Default.Edit, contentDescription = "Edit")
            }
            Spacer(modifier = Modifier.width(16.dp))
            IconButton(onClick = onDelete) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
            }
        }
    }
}