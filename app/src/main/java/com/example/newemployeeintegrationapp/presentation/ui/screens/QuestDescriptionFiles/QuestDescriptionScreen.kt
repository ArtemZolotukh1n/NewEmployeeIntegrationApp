package com.example.newemployeeintegrationapp.presentation.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newemployeeintegrationapp.presentation.viewModels.QuestScreenViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun QuestDescScreen(
    desc: String?,
    taskName: String?,
    taskId: Int,
    navController: NavController,
    viewModel: QuestScreenViewModel
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 60.dp),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.setTaskAsDone(taskId)
                    viewModel.onTaskCompleted()
                    navController.popBackStack()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(
                    Icons.Default.Check,
                    contentDescription = "Complete Task",
                    tint = Color.White
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 11.dp, top = 10.dp)
        ) {
            Text(
                text = taskName ?: "Failed to load task name?",
                style = MaterialTheme.typography.h1
            )
            Text(
                text = desc ?: "Failed to load description?",
                style = MaterialTheme.typography.body1
            )
        }
    }
}
