package com.example.newemployeeintegrationapp.presentation.ui.screens.LeanderBoardFiles

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newemployeeintegrationapp.R
import com.example.newemployeeintegrationapp.presentation.viewModels.LeaderboardViewModel

@Composable
fun LeaderBoardScreen(
    viewModel: LeaderboardViewModel
) {
    val usersLeaderBoard =
        viewModel.users.collectAsState().value.sortedByDescending { it.completionPercentage }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .align(CenterHorizontally)
            .padding(start = 20.dp)
        ) {
            Text(
                text = "По всем задачам", style = MaterialTheme.typography.body2
            )
           /* Icon(
                imageVector = ImageVector.vectorResource(R.drawable.polygon_1),
                contentDescription = null,
                modifier = Modifier.size(30.dp),
                Color.Red
            )*/
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 60.dp),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
        ) {
            itemsIndexed(usersLeaderBoard) { index, item ->
                LeaderBoardCardItem(
                    place = (index + 1).toString(),
                    name = item.name,
                    completionPercentage = item.completionPercentage
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}