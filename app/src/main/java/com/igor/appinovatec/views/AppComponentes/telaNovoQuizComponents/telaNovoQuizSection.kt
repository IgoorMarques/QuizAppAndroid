package com.igor.appinovatec.views.AppComponentes.telaNovoQuizComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.igor.appinovatec.data.areasQuiz
import com.igor.appinovatec.model.QuizItem

@Composable
fun TelaSelecaoAreaSection(onClick: (QuizItem) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(areasQuiz){
            item -> ComponenteTelaAreas(quizItem = item) { onClick(item) }
        }
    }
}