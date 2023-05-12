package com.igor.appinovatec.views.AppComponentes.telaNovoQuizComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.igor.appinovatec.model.QuizItem
import com.igor.appinovatec.views.ui.theme.azulItemTelaQuiz

@Composable
fun ComponenteTelaAreas(quizItem: QuizItem, onClick:() -> Unit) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        elevation = 15.dp,
        modifier = Modifier.clickable { onClick() }
    ) {
        Column(
            Modifier
                .background(Color.White)
                .size(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = quizItem.image), contentDescription = "Data Scienc",
                modifier = Modifier.size(150.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .background(azulItemTelaQuiz)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = quizItem.nome,
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
