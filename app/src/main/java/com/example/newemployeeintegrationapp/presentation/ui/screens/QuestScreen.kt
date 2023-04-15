package com.example.newemployeeintegrationapp.presentation.ui.screens

import com.example.newemployeeintegrationapp.presentation.ui.elements.CustomProgressBars


import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.newemployeeintegrationapp.domain.model.Task
import com.example.newemployeeintegrationapp.presentation.viewModels.QuestScreenViewModel
import com.example.newemployeeintegrationapp.R
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun MainQuestScreen(viewModel: QuestScreenViewModel) {
    val requiredTasks = viewModel.requiredTasks.collectAsState().value
    val optionalTasks = viewModel.optionalTasks.collectAsState().value
    val teamBuildingTasks = viewModel.teamBuildingTasks.collectAsState().value
    LazyColumn(
        modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(top = 8.dp, bottom = 8.dp)
    ) {
        item {
            MainQuestsColumn(
                requiredTasks, optionalTasks, teamBuildingTasks
            )
        }
        item {
            Text(
                text = "Прогресс",
                modifier = Modifier.padding(start = 11.dp, top = 8.dp),
                style = MaterialTheme.typography.h1
            )
        }
        item {
            CustomProgressBars(
                requiredTasks.map { it.isDone == 1 }.size.toFloat() / viewModel.requiredAmount.collectAsState().value,
                optionalTasks.map { it.isDone == 1 }.size.toFloat() / viewModel.optionalAmount.collectAsState().value,
                teamBuildingTasks.map { it.isDone == 1 }.size.toFloat() / viewModel.teamBuildingAmount.collectAsState().value
            )
        }
    }
}


@Composable
fun MainQuestsColumn(
    mainTasks: List<Task>, secondaryTasks: List<Task>, additionalTasks: List<Task>
) {

    Column(
        modifier = Modifier

    ) {
        Card(
            shape = RoundedCornerShape(16.dp), // Rounded corners
            border = BorderStroke(1.dp, Color.Black), // Border
            backgroundColor = Color(0xFF232222), // Gray background color
            elevation = 4.dp
        ) {
            TasksList(
                mainTasks, "Обязательные задачи", R.drawable.polygon_1
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 6.dp))
        Card(
            shape = RoundedCornerShape(16.dp), // Rounded corners
            border = BorderStroke(1.dp, Color.Black), // Border
            backgroundColor = Color(0xFF232222), // Gray background color
            elevation = 4.dp
        ) {
            TasksList(
                secondaryTasks, "Дополнительные задачи", R.drawable.polygon_2, Color(0xff9354FA)
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 6.dp))
        Card(
            shape = RoundedCornerShape(16.dp), // Rounded corners
            border = BorderStroke(1.dp, Color.Black), // Border
            backgroundColor = Color(0xFF232222), // Gray background color
            elevation = 4.dp
        ) {
            TasksList(
                additionalTasks, "Тимбилдинг", R.drawable.polygon_3, Color(0xff2C9BEC)
            )
        }
    }
}

@Composable
fun TasksList(
    quests: List<Task>,
    taskPriority: String,
    @DrawableRes image: Int,
    color: Color = Color(0xFFFF0000)
) {
    Column(
        modifier = Modifier
            .padding(start = 11.dp)
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text(text = taskPriority, style = MaterialTheme.typography.h1)
            Icon(
                imageVector = ImageVector.vectorResource(image),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .size(30.dp),
                tint = color
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .heightIn(max = 135.dp)
        ) {
            LazyColumn(modifier = Modifier.padding(start = 15.dp)) {
                items(quests) { quest ->
                    FlowRow(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = quest.task,
                            style = MaterialTheme.typography.body1,
                            overflow = TextOverflow.Ellipsis
                        )

                    }
                }
            }
        }
    }
}

