package com.example.newemployeeintegrationapp.navigation

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.eestechhckathon.QuestTopAppBar
import com.example.eestechhckathon.QuestTopAppBarWithBackArrow
import com.example.newemployeeintegrationapp.presentation.ui.screens.AllTasksByTypeFiles.AllTasksByTypeScreen
import com.example.newemployeeintegrationapp.presentation.ui.screens.KnowledgeDatabaseScreen
import com.example.newemployeeintegrationapp.presentation.ui.screens.MainQuestScreen
import com.example.newemployeeintegrationapp.presentation.ui.screens.QuestDescScreen
import com.example.newemployeeintegrationapp.presentation.ui.screens.SettingsFiles.SettingsScreen
import com.example.newemployeeintegrationapp.presentation.viewModels.QuestScreenViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavGraph(navController: NavHostController, questScreenViewModel: QuestScreenViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screen.QuestScreen.route
    )
    {
        composable(Screen.QuestScreen.route) {
            Scaffold(topBar = { QuestTopAppBar(screenTitle = "Список задач", navController) }) {
                MainQuestScreen(questScreenViewModel, navController)
            }
        }

        composable(Screen.KnowledgeScreen.route) {
            Scaffold(topBar = { QuestTopAppBar(screenTitle = "База знаний", navController) }) {
                KnowledgeDatabaseScreen()
            }
        }

        composable(Screen.QuestDescScreen.route.plus("/{taskDesc}/{taskName}/{taskId}")) { backStackEntry ->
            Scaffold(topBar = {
                QuestTopAppBarWithBackArrow(
                    screenTitle = "Описание задания",
                    navController
                )
            }) {
                QuestDescScreen(
                    backStackEntry.arguments?.getString("taskDesc"),
                    backStackEntry.arguments?.getString("taskName"),
                    backStackEntry.arguments?.getString("taskId")?.toIntOrNull() ?: -1,
                    navController = navController,
                    viewModel = questScreenViewModel
                )
            }
        }

        composable(Screen.SettingsScreen.route) {
            Scaffold(topBar = { QuestTopAppBar(screenTitle = "Настройки", navController) }) {
                SettingsScreen()
            }
        }

        composable(Screen.AllTasksByTypeScreen.route.plus("/{taskPriority}")) { backStackEntry ->
            Scaffold(topBar = {
                QuestTopAppBarWithBackArrow(
                    screenTitle = backStackEntry.arguments?.getString("taskPriority")
                        ?: "Ты куда нажал?",
                    navController
                )
            }) {
                AllTasksByTypeScreen(
                    backStackEntry.arguments?.getString("taskPriority"),
                    questScreenViewModel
                )
            }
        }
    }
}