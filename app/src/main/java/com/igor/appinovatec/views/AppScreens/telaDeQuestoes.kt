package com.igor.appinovatec.views.AppScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.igor.appinovatec.R
import com.igor.appinovatec.model.QuizQuestion
import com.igor.appinovatec.views.ui.theme.Teal200
import com.igor.appinovatec.views.ui.theme.backGround

@Composable
fun MultipleChoiceQuestion(
    questao: QuizQuestion,
    questaoAtual: Int,
    totalQuestoes: Int,
    tempoMax: Long,
    tempoAtual: Long,
    opcaoSelecionada: String,
    checkBoxSelecionada: Boolean,
    quandoMarcadaOpcao: (String) -> Unit,
    btAvancar: () -> Unit,
    btResponder: () -> Unit,
    content: @Composable () -> Unit
) {
    val cores = if (tempoAtual <= 5L) if (tempoAtual % 2 == 0L) Color.Red else backGround
    else backGround
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(cores),
        contentAlignment = Alignment.TopCenter
    ) {

        Column(
            modifier = Modifier
                .background(color = Color.Transparent)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            content()
            InfoFragmentoQuiz(
                tempoMax = tempoMax,
                tempoAtual = tempoAtual,
                totalQuestoes = totalQuestoes,
                questaoAtual = questaoAtual
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.95f)
                    .fillMaxHeight(0.9f)
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    if (tempoAtual != 0L) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(fraction = (questaoAtual.toFloat() / totalQuestoes.toFloat()))
                                .height(8.dp)
                                .background(Teal200)
                        )
                    }
                    QuizSection(
                        tempoAtual = tempoAtual,
                        questao = questao.questao,
                        options = questao.alternativas,
                        selectedOption = opcaoSelecionada,
                        isCheckboxSelected = checkBoxSelecionada,
                        quandoMarcadaOpcao = quandoMarcadaOpcao,
                        botaoAvancar = btAvancar,
                        botaoResponder = btResponder,
                        questaoAtual = questaoAtual,
                    )
                }

            }
            Spacer(modifier = Modifier.fillMaxWidth())

        }
    }

}


@Composable
fun InfoFragmentoQuiz(
    questaoAtual: Int,
    totalQuestoes: Int,
    tempoMax: Long,
    tempoAtual: Long,
) {
    Surface(elevation = 15.dp) {
        Box(
            modifier = Modifier
                .background(
                    colorResource(id = R.color.backgroundTelaSplash),
                )
                .fillMaxWidth()
                .heightIn(30.dp, 40.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
            ) {

                Text(
                    text = "Questões: ${questaoAtual}/$totalQuestoes", fontSize = 16.sp,
                    color = Color.White, fontWeight = FontWeight.Bold
                )
                val cores = if (tempoAtual <= 10L) {
                    if (tempoAtual % 2 == 0L) Color.White else Color.Red
                } else {
                    Color.White
                }

                Text(
                    text = "Tempo: " + formatTime(time = tempoAtual) + "s ($tempoMax" + "s)",
                    fontSize = 16.sp,
                    color = cores, fontWeight = FontWeight.Bold
                )

            }
        }


    }

}

fun formatTime(time: Long): String {
    val minutes = time / 60
    val seconds = time % 60
    return String.format("%02d:%02d", minutes, seconds)
}


@Composable
fun QuizSection(
    tempoAtual: Long,
    questao: String,
    options: List<String>?,
    selectedOption: String,
    isCheckboxSelected: Boolean,
    quandoMarcadaOpcao: (String) -> Unit,
    botaoAvancar: () -> Unit,
    botaoResponder: () -> Unit,
    questaoAtual: Int,

) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column() {
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(80.dp, 200.dp)
                        .verticalScroll(rememberScrollState()),
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "$questaoAtual.",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        questao,
                        textAlign = TextAlign.Justify,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(10.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    var contador = 1
                    Spacer(modifier = Modifier)
                    options?.forEach { option ->
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        color = if (selectedOption == option) Teal200
                                        else backGround
                                    )
                                    .clickable(enabled = tempoAtual != 0L) {
                                        quandoMarcadaOpcao(option)
                                    }
                                    .padding(horizontal = 20.dp)
                                    .fillMaxWidth()
                                    .heightIn(min = 50.dp),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                Text(
                                    text = "$contador. $option",
                                    modifier = Modifier
                                        .padding(start = 8.dp),
                                    color = if (isCheckboxSelected.and(selectedOption == option)) Color.White else Color.Black
                                )
                            }
                        }
                        contador = +1
                    }
                    Spacer(modifier = Modifier.height(100.dp))
                }
            }
        }
        if (tempoAtual == 0L) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer(alpha = 0.8f)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Tempo esgotado!\nIr para próxima questão",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )

                    Icon(
                        Icons.Rounded.KeyboardArrowRight, contentDescription = "next",
                        modifier = Modifier
                            .size(100.dp)
                            .clickable { botaoAvancar() },
                        tint = Teal200
                    )
                }
            }
        }

        if (tempoAtual != 0L) {
            Surface(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = (-10).dp)
            ) {
                Box(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight(0.085f)
                    .clickable(isCheckboxSelected) {
                        botaoResponder()
                    }
                    .background(if (isCheckboxSelected) Teal200 else backGround),
                    contentAlignment = Alignment.Center
                )
                {
                    Text(
                        "Responder",
                        color = if (isCheckboxSelected) Color.White else Color.Black,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                }
            }
        }
    }
}



