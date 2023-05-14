package com.example.newemployeeintegrationapp.presentation.ui.screens

import com.example.newemployeeintegrationapp.presentation.ui.elements.CustomProgressBars


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newemployeeintegrationapp.presentation.viewModels.QuestScreenViewModel
import com.example.newemployeeintegrationapp.presentation.ui.screens.QuestScreenFiles.MainQuestsColumn

@Composable
fun MainQuestScreen(
    viewModel: QuestScreenViewModel,
    navController: NavController
) {
    val requiredTasks = viewModel.requiredTasks.collectAsState().value
    val optionalTasks = viewModel.optionalTasks.collectAsState().value
    val teamBuildingTasks = viewModel.teamBuildingTasks.collectAsState().value
    val requiredTasksTarget = viewModel.completedRequiredAmount.collectAsState().value
    val optionalTasksTarget = viewModel.completedOptionalAmount.collectAsState().value
    val teamBuildingTasksTarget = viewModel.completedTeamBuildingAmount.collectAsState().value
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 60.dp),
        contentPadding = PaddingValues(top = 8.dp, bottom = 8.dp)
    ) {
        item {
            MainQuestsColumn(
                requiredTasks, optionalTasks, teamBuildingTasks, navController
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
                requiredTasks.size.toFloat(),
                optionalTasks.size.toFloat(),
                teamBuildingTasks.size.toFloat(),
                requiredTasksTarget,
                optionalTasksTarget,
                teamBuildingTasksTarget
            )
        }
    }
}
