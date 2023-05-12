package com.igor.appinovatec.views.AppScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.igor.appinovatec.R
import com.igor.appinovatec.data.areasQuiz
import com.igor.appinovatec.model.QuizItem
import com.igor.appinovatec.views.ui.theme.Teal200
import com.igor.appinovatec.views.ui.theme.backGround


@Composable
fun TelaConfigQuiz(
    itemQuiz: QuizItem,
    valorLinha: Float,
    valorLinhaTempo: Float,
    modifier: Modifier,
    modifierTempo: Modifier,
    selectedBtLevel: String,
    btLevelJunior: () -> Unit,
    btLevelPleno: () -> Unit,
    btLevelSenior: () -> Unit,
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
            horizontalAlignment = Alignment.CenterHorizontally
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
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Text(
                    text = "Nível de experiência",
                    modifier = Modifier.padding(10.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Spacer(modifier = Modifier.width(10.dp))
                    Box(
                        modifier = Modifier
                            .background(
                                color = if (selectedBtLevel == "junior") Color.Cyan
                                else backGround
                            )
                            .clickable {
                                btLevelJunior()
                            }
                    ) {
                        Text(
                            text = "Junior",
                            fontSize = 18.sp,
                            modifier = Modifier
                                .padding(10.dp)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .background(
                                color = if (selectedBtLevel == "pleno") Color.Cyan
                                else backGround
                            )
                            .clickable { btLevelPleno() }
                    ) {
                        Text(
                            text = "Pleno", modifier = Modifier.padding(10.dp),
                            fontSize = 18.sp
                        )
                    }
                    Box(
                        modifier = Modifier
                            .background(
                                color = if (selectedBtLevel == "senior")
                                    Color.Cyan
                                else
                                    backGround
                            )
                            .clickable { btLevelSenior() }
                    ) {
                        Text(
                            text = "Senior",
                            modifier = Modifier.padding(10.dp),
                            fontSize = 18.sp,
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
            Column {

                Text(
                    text = "Número de questões do teste",
                    modifier = Modifier.padding(10.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                LinhaDeslizante(20, modifier, valorLinha)
            }
            Column {
                Text(
                    text = "Tempo por questão",
                    modifier = Modifier.padding(10.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                LinhaDeslizante(60, modifierTempo, valorLinhaTempo)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
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
                    val sucessefull = (((valorLinha) / 950 * 20).toInt() >= 5)
                        .and((valorLinhaTempo / 950 * 60).toInt() >= 10)
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(fraction = .5f)
                            .background(
                                color = if (sucessefull)
                                    Color.Green
                                else
                                    backGround
                            )
                            .padding(10.dp)
                            .clickable(enabled = sucessefull) { btConfirmar() }
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
fun LinhaDeslizante(maxValor: Int, modifier: Modifier, valorLinha: Float) {

    Surface() {
        Box(
            modifier
                .background(backGround)
                .fillMaxWidth(fraction = 950f / 950f),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(fraction = valorLinha/950)
                        .fillMaxHeight()
                        .background(Teal200),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Surface(
                        shape = RoundedCornerShape(100),
                        modifier = Modifier.offset(x = 20.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .background(colorResource(id = R.color.backgroundTelaSplash)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "${((valorLinha) / 950 * maxValor).toInt()}",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                }
            }

        }
    }
}