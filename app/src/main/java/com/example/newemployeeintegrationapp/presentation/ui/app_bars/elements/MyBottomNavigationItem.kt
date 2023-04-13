package com.example.newemployeeintegrationapp.presentation.ui.app_bars.elements

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

data class MyBottomNavigationItem(
    val icon: @Composable () -> Unit,
    val selected: Boolean,
    val onClick: () -> Unit,
    val modifier: Modifier
)
