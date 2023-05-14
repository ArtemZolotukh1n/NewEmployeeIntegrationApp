package com.example.newemployeeintegrationapp.presentation.ui.screens.ProfileFiles

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.newemployeeintegrationapp.R

@Composable
fun UserProfileProgressRow(
    requiredProgress: Float,
    optionalProgress: Float,
    teamBuildingProgress: Float,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        ProgressPolygon(
            progress = requiredProgress,
            image = R.drawable.red_polygon,
            taskPriority = "Обязательные задачи",
            modifier = Modifier.weight(1f)
        )
        ProgressPolygon(
            progress = optionalProgress,
            image = R.drawable.purple_polygon,
            taskPriority = "Дополнительные задачи",
            modifier = Modifier.weight(1f)
        )
        ProgressPolygon(
            progress = teamBuildingProgress,
            image = R.drawable.blue_polygon,
            taskPriority = "Тимбилдинг",
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview
@Composable
fun prevbiew() {
    UserProfileProgressRow(1f, 1f, 1f)
}