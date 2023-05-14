package com.example.newemployeeintegrationapp.presentation.ui.screens.AllTasksByTypeFiles

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.newemployeeintegrationapp.domain.model.Task
import com.example.newemployeeintegrationapp.presentation.viewModels.QuestScreenViewModel
import com.example.newemployeeintegrationapp.R

@Composable
fun AllTasksByTypeScreen(taskPriority: String?, viewModel: QuestScreenViewModel) {
    val tasks = when (taskPriority) {
        "Обязательные задачи" -> viewModel.requiredTasks.collectAsState().value.sortedBy { it.isDone == 1 }
        "Дополнительные задачи" -> viewModel.optionalTasks.collectAsState().value.sortedBy { it.isDone == 1 }
        "Тимбилдинг" -> viewModel.teamBuildingTasks.collectAsState().value.sortedBy { it.isDone == 1 }
        else -> emptyList<Task>()
    }

    val polygon = when (taskPriority) {
        "Обязательные задачи" -> R.drawable.polygon_1
        "Дополнительные задачи" -> R.drawable.polygon_2
        else -> R.drawable.polygon_3
    }

    val polygonColor = when (taskPriority) {
        "Обязательные задачи" -> Color(0xFFFF0000)
        "Дополнительные задачи" -> Color(0xff9354FA)
        else -> Color(0xFF2C9BEC)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, bottom = 60.dp, top = 8.dp)
    ) {
        item {
            Row {
                Text(text = taskPriority ?: "ЧТО?", style = MaterialTheme.typography.h1)
                Icon(
                    imageVector = ImageVector.vectorResource(polygon),
                    contentDescription = null,
                    modifier = Modifier.size(36.dp),
                    polygonColor
                )
            }
        }

        items(tasks) { task ->
            Row(modifier = Modifier.fillMaxWidth()) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.star),
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 2.dp),
                    if (task.isDone == 1) Color.Yellow else Color.White
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = task.task, style = MaterialTheme.typography.body1)
            }
        }
    }

}

