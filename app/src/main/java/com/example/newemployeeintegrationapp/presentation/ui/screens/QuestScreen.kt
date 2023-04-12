package com.example.newemployeeintegrationapp.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newemployeeintegrationapp.presentation.viewModels.QuestScreenViewModel

@Composable
fun QuestScreen(viewModel: QuestScreenViewModel) {
    val tasks = viewModel.AllTasks.collectAsState().value

    LazyColumn() {
        items(tasks) { task ->
            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = task.taskType)
                Text(text = task.task)
                Text(text = task.description)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}