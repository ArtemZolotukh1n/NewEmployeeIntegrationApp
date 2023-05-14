package com.example.newemployeeintegrationapp.navigation

sealed class Screen {
    object QuestScreen : Screen() {
        const val route = "quest_screen"
    }

    object KnowledgeScreen : Screen() {
        const val route = "knowledge_screen"
    }

    object QuestDescScreen : Screen() {
        const val route = "quest_desc_screen"
    }

    object ProfileScreen : Screen() {
        const val route = "profile_screen"
    }

    object LeaderBoardScreen : Screen() {
        const val route = "leader_board_screen"
    }

    object AllTasksByTypeScreen : Screen() {
        const val route = "all_tasks_by_type_screen"
    }

    object SettingsScreen : Screen() {
        const val route = "settings_screen"
    }
}
