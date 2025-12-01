package com.example.getitdone.ui.screens

import com.example.getitdone.data.GetItDone
import com.example.getitdone.ui.viewModel.GIDViewModel
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*

@Composable
fun AddScreen(viewModel: GIDViewModel, onBack: () -> Unit) {
    var title by remember { mutableStateOf("") }
    var details by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Task Title") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = details,
            onValueChange = { details = it },
            label = { Text("Details") },
            modifier = Modifier.fillMaxWidth().height(150.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                      if (title.isNotBlank()) {
                          val newTask = GetItDone(title = title, details = details)
                          viewModel.insertTodo(newTask)
                          onBack()
                      }
                      },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Save")
        }
    }
}
