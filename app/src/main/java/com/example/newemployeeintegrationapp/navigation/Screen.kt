package com.example.newemployeeintegrationapp.navigation

sealed class Screen {
    object QuestScreen : Screen() {
        const val route = "quest_screen"
    }
    object KnowledgeScreen : Screen() {
        const val route = "knowledge_screen"
    }
}
