package com.igor.appinovatec.views.AppScreens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.igor.appinovatec.R
import com.igor.appinovatec.views.ui.theme.Teal200


@Composable
fun TelaDeAviso(onStartClick: () -> Unit, onCloseClick: () -> Unit) {
    Dialog(onDismissRequest = { onCloseClick() }) {
        Box(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth(0.95f)
                .fillMaxHeight(0.9f),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Box(
                    modifier = Modifier
                        .align(Start)
                        .offset(x = 10.dp, y = 10.dp)
                        .clickable { onCloseClick() }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_close),
                        contentDescription = "fechar quiz"
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.quiz),
                    contentDescription = "quiz img",
                    modifier = Modifier.size(100.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Caro canditado,\n" +
                            "\n" +
                            "Você recebeu este formulário com \n" +
                            "questões técnicas referentes a vaga \n" +
                            "para Data Science Jr. da XYZ Softwares, \n" +
                            "como etapa do processo seletivo ao \n" +
                            "referido cargo!\n" +
                            "\n" +
                            "Responda este formulário com atenção,\n" +
                            "e após iniciado, não há opção de \n" +
                            "interrompe-lo para posterior \n" +
                            "finalização!\n" +
                            "\n" +
                            "Em caso de dúvidas, entre em contato \n" +
                            "com o setor responsável pelo processo\n" +
                            "seletivo da XYZ Softwares!\n" +
                            "\n" +
                            "Boa sorte e máxima atenção!",
                    textAlign = TextAlign.Justify,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                )
                Spacer(modifier = Modifier.height(40.dp))
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    elevation = 8.dp,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .fillMaxWidth(0.5f)
                        .clickable { onStartClick() },

                    ) {
                    Text(
                        text = "Iniciar", fontSize = 20.sp,
                        modifier = Modifier
                            .background(Teal200)
                            .padding(
                                start = 10.dp, end = 10.dp, bottom = 5.dp,
                                top = 5.dp
                            ),
                        textAlign = TextAlign.Center
                    )
                }

            }
        }
    }
}

@Preview
@Composable
fun VerApp() {
    TelaDeAviso(onStartClick = {}) {
    }
}
