package com.example.newemployeeintegrationapp.presentation.ui.screens.QuestScreenFiles

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newemployeeintegrationapp.domain.model.Task
import com.example.newemployeeintegrationapp.navigation.Screen
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun TasksList(
    quests: List<Task>,
    taskPriority: String,
    @DrawableRes image: Int,
    color: Color = Color(0xFFFF0000),
    navController: NavController
) {
    Column(
        modifier = Modifier
            .padding(start = 11.dp)
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = taskPriority,
                style = MaterialTheme.typography.h1,
                modifier = Modifier.clickable {
                    navController.navigate(Screen.AllTasksByTypeScreen.route.plus("/$taskPriority"))
                }
            )
            Icon(
                imageVector = ImageVector.vectorResource(image),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .size(30.dp),
                tint = color
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .heightIn(max = 135.dp)
        ) {
            LazyColumn(modifier = Modifier.padding(start = 15.dp)) {
                items(quests.filter { it.isDone == 0 }) { quest ->
                    FlowRow(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = quest.task,
                            style = MaterialTheme.typography.body1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.clickable {
                                navController.navigate(
                                    Screen.QuestDescScreen.route.plus(
                                        "/${quest.description}/${quest.task}/${quest.id}"
                                    )
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}
