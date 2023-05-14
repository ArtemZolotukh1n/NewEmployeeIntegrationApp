package com.example.newemployeeintegrationapp.presentation.ui.screens.ProfileFiles

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AchievementRow(
    achievements: List<Achievement>,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        achievements.forEach { achievement ->
            AchievementItem(
                achievement = achievement,
                modifier = Modifier
                    .weight(1f)

            )
        }
    }

}