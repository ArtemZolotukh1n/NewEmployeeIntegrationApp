package com.example.newemployeeintegrationapp.presentation.ui.screens.QuestScreenFiles

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newemployeeintegrationapp.domain.model.Task

@Composable
fun QuestCard(
    tasks: List<Task>,
    taskPriority: String,
    @DrawableRes polygon: Int,
    color: Color,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp), // Rounded corners
        border = BorderStroke(1.dp, Color.Black), // Border
        backgroundColor = Color(0xFF232222), // Gray background color
        elevation = 4.dp
    ) {
        TasksList(
            tasks,
            taskPriority,
            polygon,
            color,
            navController
        )
    }
}