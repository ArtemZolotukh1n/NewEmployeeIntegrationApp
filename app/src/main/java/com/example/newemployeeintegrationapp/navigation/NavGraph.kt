package com.example.newemployeeintegrationapp.navigation

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.eestechhckathon.QuestTopAppBar
import com.example.newemployeeintegrationapp.presentation.ui.screens.KnowledgeDatabaseScreen
import com.example.newemployeeintegrationapp.presentation.ui.screens.MainQuestScreen
import com.example.newemployeeintegrationapp.presentation.viewModels.QuestScreenViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.QuestScreen.route
    )
    {
        composable(Screen.QuestScreen.route) {
            val viewModel = hiltViewModel<QuestScreenViewModel>()
            Scaffold(topBar = { QuestTopAppBar(screenTitle = "Список задач", navController) }) {
                MainQuestScreen(viewModel)
            }
        }

        composable(Screen.KnowledgeScreen.route) {
            Scaffold(topBar = { QuestTopAppBar(screenTitle = "База знаний", navController) }) {
                KnowledgeDatabaseScreen()
            }
        }
    }
}