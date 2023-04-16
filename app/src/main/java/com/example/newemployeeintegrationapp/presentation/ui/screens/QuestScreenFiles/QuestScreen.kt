package com.example.newemployeeintegrationapp.presentation.ui.screens

import com.example.newemployeeintegrationapp.presentation.ui.elements.CustomProgressBars


import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import com.example.newemployeeintegrationapp.domain.model.Task
import com.example.newemployeeintegrationapp.presentation.viewModels.QuestScreenViewModel
import com.example.newemployeeintegrationapp.R
import com.example.newemployeeintegrationapp.navigation.Screen
import com.example.newemployeeintegrationapp.presentation.ui.screens.QuestScreenFiles.MainQuestsColumn
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun MainQuestScreen(viewModel: QuestScreenViewModel, navController: NavController) {
    val requiredTasks = viewModel.requiredTasks.collectAsState().value
    val optionalTasks = viewModel.optionalTasks.collectAsState().value
    val teamBuildingTasks = viewModel.teamBuildingTasks.collectAsState().value
    LazyColumn(
        modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(top = 8.dp, bottom = 8.dp)
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
                requiredTasks.filter { it.isDone == 1 }.size.toFloat() / viewModel.requiredAmount.collectAsState().value,
                optionalTasks.filter { it.isDone == 1 }.size.toFloat() / viewModel.optionalAmount.collectAsState().value,
                teamBuildingTasks.filter { it.isDone == 1 }.size.toFloat() / viewModel.teamBuildingAmount.collectAsState().value
            )
        }
    }
}
