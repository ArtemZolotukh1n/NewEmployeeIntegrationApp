package com.example.newemployeeintegrationapp.presentation.ui.elements

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newemployeeintegrationapp.R

@Composable
fun CustomProgressBars() {
    // Create a mutable state to store the progress value
    val progress_one = remember { mutableStateOf(0.9f) }
    val progress_two = remember { mutableStateOf(0.6f) }
    val progress_three = remember { mutableStateOf(0.1f) }
    val animatedProgressOne = animateFloatAsState(
        targetValue = progress_one.value,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value
    val animatedProgressTwo = animateFloatAsState(
        targetValue = progress_two.value,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value
    val animatedProgressThree = animateFloatAsState(
        targetValue = progress_three.value,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value
    // Create a LinearProgressIndicator that observes the progress value and updates accordingly

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(start = 8.dp, top = 8.dp)
        ) {
            Row() {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.polygon_1),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp),
                    tint = Color(0xFFFF0000)
                )
                Spacer(Modifier.width(4.dp))
                LinearProgressIndicator(
                    progress = animatedProgressOne,
                    color = Color(0xFFEC2C2C),
                    modifier = Modifier.height(20.dp)
                )
            }
            Spacer(modifier = Modifier.padding(vertical = 4.dp))
            Row() {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.polygon_2),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp),
                    Color(0xff9354FA)

                )

                LinearProgressIndicator(
                    progress = animatedProgressTwo,
                    color = Color(0xFF9354FA),
                    modifier = Modifier.height(20.dp),
                )
            }
            Spacer(modifier = Modifier.padding(vertical = 4.dp))
            Row() {

                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.polygon_3),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp),
                    Color(0xff2C9BEC)

                )
                LinearProgressIndicator(
                    progress = animatedProgressThree,
                    color = Color(0xFF2C9BEC),
                    modifier = Modifier.height(20.dp)

                )
            }
        }
    }
}

@Composable
fun HorizontalProgressBar(
    progress: Float,
    modifier: Modifier = Modifier,
    color: Color = Color.Green,
    backgroundColor: Color = Color.Black,
    size: Size = Size(width = 10f, height = 100f),
    strokeSize: Float = 0.5f,
    strokeColor: Color = Color.Blue
) {
    Canvas(
        modifier = modifier
            .size(size.width.dp, size.height.dp)
            .border(width = strokeSize.dp, color = strokeColor)
    ) {
        // Progress made
        drawRect(
            color = color,
            size = Size(size.width.dp.toPx(), height = (progress * size.height).dp.toPx()),
            topLeft = Offset(0.dp.toPx(), ((1 - progress) * size.height).dp.toPx())
        )
        // background
        drawRect(
            color = backgroundColor,
            size = Size(
                width = size.width.dp.toPx(),
                height = ((1 - progress) * size.height).dp.toPx()
            ),
        )
    }
}


@Preview
@Composable
fun Bars() {
    CustomProgressBars()
}

