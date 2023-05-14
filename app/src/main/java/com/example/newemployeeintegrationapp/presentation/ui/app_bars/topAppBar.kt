package com.example.eestechhckathon

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.newemployeeintegrationapp.R


@Composable
fun QuestTopAppBar(screenTitle: String, navController: NavController) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.background,
        elevation = AppBarDefaults.TopAppBarElevation,
        modifier = Modifier.height(64.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
                .weight(2f),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // User profile image
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "User Profile",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            // Text "Список задач"
            Text(
                text = screenTitle,
                color = MaterialTheme.colors.onSurface,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        /*Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 8.dp)
                .weight(1f),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Search icon
            IconButton(onClick = { *//* Handle search icon click *//* }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            }
            // Bell icon
            IconButton(onClick = { *//* Handle bell icon click *//* }) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications"
                )
            }
        }*/
    }
}

