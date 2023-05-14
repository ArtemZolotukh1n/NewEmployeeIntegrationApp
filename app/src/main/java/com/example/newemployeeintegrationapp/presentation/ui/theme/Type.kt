package com.example.newemployeeintegrationapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.newemployeeintegrationapp.R

val myCustomFont = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal)
)

val myCustomFontBold = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal)
)

val progress = TextStyle(
    fontFamily = myCustomFontBold,
    fontWeight = FontWeight.Bold,
    fontSize = 28.sp
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = myCustomFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = myCustomFont,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),
    h1 = TextStyle(
        fontFamily = myCustomFont,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    h2 = TextStyle(
        fontFamily = myCustomFont,
        fontWeight = FontWeight.ExtraLight,
        color = Color.Gray,
        fontSize = 18.sp
    ),

    )