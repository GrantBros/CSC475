package com.example.getitdone.ui.screens

import com.example.getitdone.data.GetItDone
import com.example.getitdone.ui.viewModel.GIDViewModel
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.material3.*


@Composable
fun EditScreen(viewModel: GIDViewModel, task : GetItDone, onBack: () -> Unit) {
    var title by remember {mutableStateOf(task.title)}
    var details by remember {mutableStateOf(task.details)}

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        OutlinedTextField(
            value = title,
            onValueChange = {title = it},
            label = {Text("Edit Title") },
            modifier = Modifier.fillMaxWidth()
            )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = details,
            onValueChange = {details = it},
            label = {Text("Edit Details") },
            modifier = Modifier.fillMaxWidth().height(150.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (title.isNotBlank()) {
                viewModel.updateTodo(
                    task.copy(title = title, details = details)
                )
                onBack()
            }
        },
            modifier = Modifier.align(Alignment.End)
        ) {Text("Update Task")}
    }
}