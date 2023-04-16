package com.example.newemployeeintegrationapp.presentation.ui.screens.QuestScreenFiles

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newemployeeintegrationapp.R
import com.example.newemployeeintegrationapp.domain.model.Task

@Composable
fun MainQuestsColumn(
    mainTasks: List<Task>,
    secondaryTasks: List<Task>,
    additionalTasks: List<Task>,
    navController: NavController
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
                mainTasks,
                "Обязательные задачи",
                R.drawable.polygon_1,
                navController = navController
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
                secondaryTasks,
                "Дополнительные задачи",
                R.drawable.polygon_2,
                Color(0xff9354FA),
                navController
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
                additionalTasks,
                "Тимбилдинг",
                R.drawable.polygon_3,
                Color(0xff2C9BEC),
                navController
            )
        }
    }
}