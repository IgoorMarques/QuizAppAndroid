package com.igor.appinovatec.views.AppScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.igor.appinovatec.model.QuizItem
import com.igor.appinovatec.views.AppComponentes.telaNovoQuizComponents.TelaSelecaoAreaSection

@Composable
fun TelaAreas(onClick: (QuizItem) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Escolha uma área",
                modifier = Modifier.padding(10.dp),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            TelaSelecaoAreaSection(onClick)
        }
    }
}

