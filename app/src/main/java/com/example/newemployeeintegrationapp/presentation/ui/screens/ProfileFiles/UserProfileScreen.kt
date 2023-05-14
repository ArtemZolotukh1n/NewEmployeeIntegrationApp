package com.example.newemployeeintegrationapp.presentation.ui.screens.ProfileFiles

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.newemployeeintegrationapp.R
import com.example.newemployeeintegrationapp.presentation.viewModels.QuestScreenViewModel
import com.example.newemployeeintegrationapp.ui.theme.myCustomFont
import com.example.newemployeeintegrationapp.ui.theme.myCustomFontBold
import com.example.newemployeeintegrationapp.ui.theme.progress

@Composable
fun UserProfileScreen(
    viewModel: QuestScreenViewModel,
    modifier: Modifier = Modifier
) {
    val requiredTasksSize = viewModel.requiredTasks.collectAsState().value.size.toFloat()
    val optionalTasksSize = viewModel.optionalTasks.collectAsState().value.size.toFloat()
    val teamBuildingTasksSize = viewModel.teamBuildingTasks.collectAsState().value.size.toFloat()
    val completedRequiredTasks = viewModel.completedRequiredAmount.collectAsState().value
    val completedOptionalTasks = viewModel.completedOptionalAmount.collectAsState().value
    val completedTeamBuildingTasks = viewModel.completedTeamBuildingAmount.collectAsState().value

    val userPlaceOnLeaderboard = 1 // Hardcoded value for the user's place on the leaderboard

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 12.dp, bottom = 60.dp, top = 12.dp)
    ) {
        item {
            Text(
                text = "Прогресс",
                modifier = Modifier.padding(bottom = 8.dp),
                style = progress
            )
        }

        item {
            UserProfileProgressRow(
                completedRequiredTasks / requiredTasksSize * 100,
                completedOptionalTasks / optionalTasksSize * 100,
                completedTeamBuildingTasks / teamBuildingTasksSize * 100
            )
        }

        item {
            Text(
                text = "Место в лидерборде",
                style = progress,
                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
            )
        }

        item {
            Text(
                text = "Место: $userPlaceOnLeaderboard",
                style = MaterialTheme.typography.body1,
                )
        }

        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
            ) {
                Text(
                    text = "Достижения",
                    style = progress,
                )
                Text(
                    text = "3/10",
                    color = Color.Gray,
                    style = progress,
                    modifier = Modifier.padding(start = 6.dp),
                )
            }
        }
        item {
            AchievementRow(
                achievements = listOf(
                    Achievement("Первые шаги", R.drawable.baby),
                    Achievement("Душа компании", R.drawable.baloons),
                    Achievement("Чемпион", R.drawable.diamond),
                ),
            )
        }
    }
}