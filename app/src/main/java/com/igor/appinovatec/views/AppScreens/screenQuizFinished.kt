package com.igor.appinovatec.views.AppScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.igor.appinovatec.R


@Composable
fun CustomDialog(onDismiss: () -> Unit, btContinuar: () -> Unit, btQuestoes: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        // Conteúdo personalizado da dialog
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(0.95f)
                .fillMaxHeight(.8f)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Image(painter = painterResource(id = R.drawable.data), contentDescription = "",
                    modifier = Modifier.size(150.dp))
                    Text(text = "Data Science", modifier = Modifier.padding(20.dp))
                }

                Text(
                    text = "Parabéns! Você concluiu este formulário e pode seguir com os próximos",
                    modifier = Modifier.fillMaxWidth(0.8f),
                    textAlign = TextAlign.Center
                )

                Text(text = "Resultado: 3/10")
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Button(onClick = { btQuestoes() }) {
                        Text(text = "Questões")
                    }
                    Button(onClick = { btContinuar() }) {
                        Text(text = "Continuar")
                    }
                }
            }
        }
    }
}
