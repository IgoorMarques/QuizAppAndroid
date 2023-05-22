package com.igor.appinovatec.views.AppScreens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
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
import com.igor.appinovatec.data.areasQuiz
import com.igor.appinovatec.model.HomeContentItem
import com.igor.appinovatec.views.ui.theme.Teal200


@Composable
fun TelaDeAviso(infoQuiz: HomeContentItem, onStartClick: () -> Unit, onCloseClick: () -> Unit) {
    Dialog(onDismissRequest = { onCloseClick() }) {
        Box(
            modifier = Modifier
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .align(Start)
                        .offset(x = 3.dp, y = 3.dp)
                        .clickable { onCloseClick() }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_close),
                        contentDescription = "fechar quiz"
                    )
                }
                val img = areasQuiz.find { it.id == infoQuiz.id }?.image
                Image(
                    painter = painterResource(img ?: R.drawable.checklist),
                    contentDescription = "quiz img",
                    modifier = Modifier.size(100.dp)
                )
                Text(
                    text = "Caro canditado,\n" +
                            "o seguinte questionário conta \n" +
                            "com questões técnicas referentes a área \n" +
                            "de ${infoQuiz.assunto}.\n" +
                            "\n" +
                            "Responda este formulário com atenção,\n" +
                            "e após iniciado, não há opção de \n" +
                            "interrompe-lo, para posterior \n" +
                            "finalização.\n" +
                            "\n" +
                            "Caso você saia durante o andamento\n" +
                            "desse questionário\n" +
                            "suas respostas não serão salvas.\n" +
                            "\n" +
                            "Boa sorte e máxima atenção!",
                    textAlign = TextAlign.Justify,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                )
                Spacer(modifier = Modifier.height(60.dp))
            }
            Surface(
                shape = RoundedCornerShape(8.dp),
                elevation = 8.dp,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth(0.5f)
                    .clickable { onStartClick() }
                    .align(BottomCenter)
                    .offset((-5).dp),
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

