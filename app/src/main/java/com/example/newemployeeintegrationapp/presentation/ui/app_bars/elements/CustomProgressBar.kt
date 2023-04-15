package com.example.newemployeeintegrationapp.presentation.ui.elements

import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun CustomProgressBarInsideLabel(progress: Float, color: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.75f)
    ) {
        // Add LinearProgressIndicator with custom progress and increased height
        LinearProgressIndicator(
            progress = progress,
            color = color,
            modifier = Modifier
                .fillMaxWidth()
                .height(28.dp)
        )

        // Add the label text inside the progress bar
        Text(
            text = "${(progress * 100).toInt()}%",
            fontSize = 12.sp,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .graphicsLayer(rotationZ = 90f) // Rotate text by x degrees
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomProgressBarPreview() {
    Surface {
        CustomProgressBarInsideLabel(progress = 0.5f, color = Color(0xFFEC2C2C))
    }
}