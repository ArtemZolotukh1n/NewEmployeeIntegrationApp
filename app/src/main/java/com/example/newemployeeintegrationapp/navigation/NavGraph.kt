package com.example.newemployeeintegrationapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.newemployeeintegrationapp.presentation.ui.screens.MainQuestScreen
import com.example.newemployeeintegrationapp.presentation.viewModels.QuestScreenViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.QuestScreen.route
    )
    {
        composable(Screen.QuestScreen.route) {
            val viewModel = hiltViewModel<QuestScreenViewModel>()
            MainQuestScreen(viewModel)
        }
    }
}