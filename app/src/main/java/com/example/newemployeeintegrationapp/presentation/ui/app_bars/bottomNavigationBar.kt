package com.example.newemployeeintegrationapp.presentation.ui.app_bars

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.newemployeeintegrationapp.R
import com.example.newemployeeintegrationapp.presentation.ui.app_bars.elements.MyBottomNavigationItem


@Composable
fun AppsBottomNavigationBar() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        MyBottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.fi_bs_list),
                    contentDescription = "Список задач",
                    tint = if (selectedItem == 0) MaterialTheme.colors.primary else LocalContentColor.current,
                    modifier = Modifier.size(16.dp)
                )
            },
            selected = false,
            onClick = {
                selectedItem = 0
            },
            modifier = Modifier.padding(16.dp)
        ),
        MyBottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.knowlagebase),
                    contentDescription = "База знаний",
                    tint = if (selectedItem == 1) MaterialTheme.colors.primary else LocalContentColor.current,
                    modifier = Modifier.size(16.dp)
                )
            },
            selected = false,
            onClick = {
                selectedItem = 1
            },
            modifier = Modifier.padding(16.dp)
        ),
        MyBottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "Профиль",
                    tint = if (selectedItem == 2) MaterialTheme.colors.primary else LocalContentColor.current,
                    modifier = Modifier.size(16.dp)
                )
            },
            selected = false,
            onClick = {
                selectedItem = 2
            },
            modifier = Modifier.padding(16.dp)
        ),
        MyBottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.sertificat),
                    contentDescription = "Лидерборд",
                    tint = if (selectedItem == 3) MaterialTheme.colors.primary else LocalContentColor.current,
                    modifier = Modifier.size(16.dp)
                )
            },
            selected = false,
            onClick = {
                selectedItem = 3
            },
            modifier = Modifier.padding(16.dp)
        ),
        MyBottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = "Настройки",
                    tint = if (selectedItem == 4) MaterialTheme.colors.primary else LocalContentColor.current,
                    modifier = Modifier.size(16.dp)
                )
            },
            selected = false,
            onClick = {
                selectedItem = 4
            },
            modifier = Modifier.padding(16.dp)
        )
    )

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        BottomNavigation(modifier = Modifier.height(60.dp)) {
            items.forEach { item ->
                BottomNavigationItem(
                    icon = item.icon,
                    selected = false,
                    onClick = item.onClick,
                    modifier = item.modifier
                )
            }
        }
    }
}

