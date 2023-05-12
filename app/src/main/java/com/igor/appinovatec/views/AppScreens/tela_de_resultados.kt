package com.igor.appinovatec.views.AppScreens

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.igor.appinovatec.model.QuizQuestion
import com.igor.appinovatec.views.ui.theme.Teal200
import com.igor.appinovatec.views.ui.theme.backGround


@Composable
fun OvervierQuizScreen(
    questao: QuizQuestion,
    numQuestaoAtual: Int,
    opcaoSelecionada: String,
    btAvancar: () -> Unit,
    btVotlar: () -> Unit,
    btFechar: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            CabecalhoTelaResultados(btFechar)
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Resposta correta:", fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    elevation = 10.dp,
                    color = Teal200,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = questao.alternativaCorreta,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(300),
                        modifier = Modifier.padding(
                            start = 15.dp,
                            top = 10.dp,
                            bottom = 10.dp,
                            end = 15.dp
                        )
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .fillMaxHeight(0.9f)
            ) {
                QuizQuestionResult(
                    questao = questao,
                    numQuestaoAtual = numQuestaoAtual,
                    opcaoSelecionada = opcaoSelecionada
                )
            }
        }

        Icon(
            Icons.Rounded.ArrowBack, contentDescription = "voltar",
            modifier = Modifier
                .align(Alignment.BottomStart)
                .size(50.dp)
                .offset(x = 25.dp, y = (-10).dp)
                .clickable { btVotlar() }
        )
        Icon(
            Icons.Rounded.ArrowForward, contentDescription = "proximo",
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(50.dp)
                .offset(x = (-25).dp, y = (-10).dp)
                .clickable { btAvancar() }
        )
    }

}


@Composable
fun CabecalhoTelaResultados(
    btFechar: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Rounded.Close, contentDescription = "fechar",
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 10.dp, y = 10.dp)
                    .clickable { btFechar() }
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxHeight(0.20f),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Spacer(modifier = Modifier)
                Text(
                    text = "Data Science",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = "Feito em 22/10/23 às 14:50",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(10.dp)
                )
                Text(
                    text = "Resultado: 5/10",
                    fontSize = 14.sp,
                )
            }
        }
    }
}


@Composable
fun QuizQuestionResult(
    questao: QuizQuestion,
    numQuestaoAtual: Int,
    opcaoSelecionada: String,

    ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
                    text = numQuestaoAtual.toString(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    questao.questao,
                    textAlign = TextAlign.Justify,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .heightIn(min = 50.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                questao.alternativas.forEach { opcao ->
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                    ) {
                        Box(
                            modifier = Modifier
                                .background(
                                    color = if (opcaoSelecionada == opcao)
                                        if (opcaoSelecionada == questao.alternativaCorreta)
                                        Teal200 else
                                        Color.Red else backGround
                                )
                                .border(width = if (questao.alternativaCorreta == opcao) 3.dp else (-1).dp, color = Teal200)
                                .padding(horizontal = 20.dp)
                                .fillMaxWidth()
                                .heightIn(min = 50.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Column() {
                                if (opcaoSelecionada == opcao){
                                    Text("Sua resposta",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.W800,
                                        modifier = Modifier

                                    )
                                }
                                Text(
                                    text = "1 - $opcao",
                                    modifier = Modifier
                                        .padding(
                                            start = 8.dp,
                                            end = 8.dp,
                                            top = 10.dp,
                                            bottom = 10.dp
                                        ),
                                    color =  Color.Black
                                )
                            }
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}

