package com.example.newemployeeintegrationapp.presentation.ui.elements

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.newemployeeintegrationapp.R
import com.example.newemployeeintegrationapp.presentation.ui.app_bars.elements.ProgressBarRow

@Composable
fun CustomProgressBars(
    firstProgressTarget: Float,
    secondProgressTarget: Float,
    thirdProgressTarget: Float,
    firstProgress: Float,
    secondProgress: Float,
    thirdProgress: Float,
) {
    val progress_one =
        firstProgress / firstProgressTarget
    val progress_two =
        secondProgress / secondProgressTarget
    val progress_three =
        thirdProgress / thirdProgressTarget
    val animatedProgressOne = animateFloatAsState(
        targetValue = progress_one,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value
    val animatedProgressTwo = animateFloatAsState(
        targetValue = progress_two,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value
    val animatedProgressThree = animateFloatAsState(
        targetValue = progress_three,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(start = 8.dp, top = 8.dp)
        ) {
            ProgressBarRow(R.drawable.polygon_1, Color(0xFFFF0000), animatedProgressOne)
            Spacer(modifier = Modifier.padding(vertical = 4.dp))

            ProgressBarRow(R.drawable.polygon_2, Color(0xff9354FA), animatedProgressTwo)
            Spacer(modifier = Modifier.padding(vertical = 4.dp))

            ProgressBarRow(R.drawable.polygon_3, Color(0xFF2C9BEC), animatedProgressThree)

        }
    }
}

