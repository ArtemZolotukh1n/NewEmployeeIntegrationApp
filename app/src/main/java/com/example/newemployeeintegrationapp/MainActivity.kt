package com.example.newemployeeintegrationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.newemployeeintegrationapp.domain.model.Task
import com.example.newemployeeintegrationapp.presentation.viewModels.QuestScreenViewModel
import com.example.newemployeeintegrationapp.ui.theme.NewEmployeeIntegrationAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewEmployeeIntegrationAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val viewModel: QuestScreenViewModel = viewModel()
                    val tasks by viewModel.tasks.collectAsState()
                    columnShit(tasks = tasks)
                }
            }
        }
    }
}


@Composable
fun columnShit(tasks: List<Task>) {
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