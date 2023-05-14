package com.example.newemployeeintegrationapp.presentation.ui.app_bars.elements

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.newemployeeintegrationapp.presentation.ui.elements.CustomProgressBarInsideLabel

@Composable
fun ProgressBarRow(@DrawableRes polygon: Int, color: Color, animatedProgress: Float) {
    Row() {
        Icon(
            imageVector = ImageVector.vectorResource(polygon),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp),
            color

        )
        CustomProgressBarInsideLabel(
            progress = animatedProgress,
            color = color,
        )
    }
}