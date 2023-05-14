package com.example.newemployeeintegrationapp.presentation.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.newemployeeintegrationapp.R

@Composable
fun KnowledgeDatabaseScreen() {
    val items = listOf(
        GridItem(R.drawable.pointingfinger, "Техника безопасности"),
        GridItem(R.drawable.book, "Инструкции и регламент"),
        GridItem(R.drawable.planet, "Система RNS.WEB"),
        GridItem(R.drawable.court, "Корпоративная культура"),
        GridItem(R.drawable.infinite, "Произвольный блок"),
        GridItem(R.drawable.infinite, "Произвольный блок"),
    )

    // Используем LazyVerticalGrid для создания сетки
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier.padding(bottom = 60.dp)
    ) {
        items(items) { item ->
            // Используем Card, чтобы создать закругленный квадрат с тенью
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clickable { /* Обработка клика на элементе */ },
                elevation = 4.dp,
                shape = RoundedCornerShape(20.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Используем Image для отображения изображения
                    Icon(
                        imageVector = ImageVector.vectorResource(item.image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(64.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        Color.White
                    )

                    // Используем Text для отображения текста
                    Text(
                        text = item.text,
                        modifier = Modifier.padding(top = 8.dp),
                        textAlign = TextAlign.Center,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.subtitle2
                    )
                }
            }
        }
    }
}

// Класс элемента сетки
data class GridItem(
    val image: Int,
    val text: String
)
