package com.igor.appinovatec.views.conversaoXmlToCompose

import android.view.LayoutInflater
import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import com.igor.appinovatec.R

@Composable
fun TelaDeLogin(onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                LayoutInflater.from(context).inflate(R.layout.activity_tela_cadastro_usuario, null)
            },
            update = { view ->
                view.findViewById<Button>(R.id.btEntrar).setOnClickListener {
                    onClick()
                }
            }
        )
        val mostrarTelaAviso = remember {
            mutableStateOf(false)
        }
        Image(
            painter = painterResource(id = android.R.drawable.ic_dialog_info),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable {
                    mostrarTelaAviso.value = true
                }
        )
        if (mostrarTelaAviso.value) {
            infoMsg {
                mostrarTelaAviso.value = false
            }
        }
    }
}


@Composable
fun infoMsg(onClick: () -> Unit) {
    Dialog(onDismissRequest = { onClick() }) {
        Column(
            Modifier
                .background(Color.White)
                .padding(horizontal = 20.dp, vertical = 10.dp)
        ) {
            Text(text = "Desenvolvimento\n", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Text(
                text = "Desenvolvido por:\n" +
                        "   Igor Marques\n" +
                        "   Diogo Pena Rezendo\n" +
                        "   José Otávio Coelho da Silva Junior\n" +
                        "\n" +
                        "Apresentado em Março/2023\n" +
                        "e finalizado em Abril/2023, da concepção\n" +
                        "do projeto de Diogo Pena Rezende"
            )
        }

    }
}
