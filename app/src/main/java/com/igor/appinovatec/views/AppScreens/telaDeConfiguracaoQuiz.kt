package com.igor.appinovatec.views.AppScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceBetween
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.igor.appinovatec.data.*
import com.igor.appinovatec.model.QuizItem
import com.igor.appinovatec.model.TelaConfigButton
import com.igor.appinovatec.views.ui.theme.Teal200
import com.igor.appinovatec.views.ui.theme.backGround


@Composable
fun TelaConfigQuiz(
    itemQuiz: QuizItem,
    selectedBtLevel: String,
    selectedBtQtdQuestoes: String,
    selectedBtTempoQuestao: String,
    selectedQuizConfig: String,
    btQuizConfigClicked: (TelaConfigButton) -> Unit,
    btTempoClicked: (TelaConfigButton) -> Unit,
    btLevelClicked: (TelaConfigButton) -> Unit,
    btQtdQuestoesClicked: (TelaConfigButton) -> Unit,
    btCancelar: () -> Unit,
    btConfirmar: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(horizontal = 10.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(itemQuiz.image),
                    contentDescription = itemQuiz.nome
                )
                Text(
                    text = itemQuiz.nome,
                    modifier = Modifier.padding(10.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = "Nível de experiência")
                Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                    btLevelTelaConfig.forEach { bt ->
                        TelaConfigButtons(
                            selectedBtLevel = selectedBtLevel,
                            telaConfigButton = bt,
                            btClicked = { btLevelClicked(bt) })
                    }
                }
                Text(text = "Número de questões")
                Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                    btQtdQuestoesTelaConfig.forEach { bt ->
                        TelaConfigButtons(
                            selectedBtLevel = selectedBtQtdQuestoes,
                            telaConfigButton = bt,
                            btClicked = { btQtdQuestoesClicked(bt) }
                        )
                    }
                }
                Text(text = "Tempo de resposta por questão")
                Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                    btTempoTelaConfig.forEach { bt ->
                        TelaConfigButtons(
                            selectedBtLevel = selectedBtTempoQuestao,
                            telaConfigButton = bt,
                            btClicked = { btTempoClicked(bt) }
                        )
                    }
                }
                Text(text = "Deseja iniciar")
                Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                    btQuizConfig.forEach { bt ->
                        TelaConfigButtons(selectedBtLevel = selectedQuizConfig,
                            telaConfigButton = bt,
                            btClicked = { btQuizConfigClicked(bt) })
                    }
                }
            }
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.spacedBy(15.dp),

            ) {
                Surface(shape = RoundedCornerShape(100)) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.3f)
                            .background(Color.Red)

                            .padding(10.dp)
                            .clickable {
                                btCancelar()
                            }
                    ) {
                        Text(
                            text = "Cancelar", color = Color.White, fontSize = 16.sp,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Surface(shape = RoundedCornerShape(100)) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(fraction = .5f)
                            .background(
                                    Color.Green
                            )
                            .padding(10.dp)
                            .clickable{ btConfirmar() }
                    ) {
                        Text(
                            text = "Confirmar", color = Color.White, fontSize = 16.sp,
                            modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center
                        )
                    }
                }

            }

            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}


@Composable
fun TelaConfigButtons(
    selectedBtLevel: String,
    telaConfigButton: TelaConfigButton,
    btClicked: () -> Unit
) {
    Surface(shape = RoundedCornerShape(100)) {
        Box(
            modifier = Modifier
                .widthIn(min = 80.dp)
                .background(
                    color = if (selectedBtLevel == telaConfigButton.name) Teal200
                    else backGround
                )
                .clickable {
                    btClicked()
                },
            contentAlignment = Center
        ) {
            Text(
                text = telaConfigButton.name,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(10.dp)
            )
        }
    }
}
