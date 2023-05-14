package com.example.newemployeeintegrationapp.presentation.ui.screens.ProfileFiles

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProgressPolygon(
    progress: Float,
    @DrawableRes image: Int,
    taskPriority: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(80.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
            )
            Text(
                text = "${progress.toInt()}%",
                color = Color.White,
                fontSize = 16.sp,
                modifier = if (taskPriority != "Дополнительные задачи") Modifier.padding(bottom = 9.dp) else Modifier
            )
        }
        Text(
            text = taskPriority,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
        )
    }
}