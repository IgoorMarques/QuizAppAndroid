package com.igor.appinovatec.views.AppScreens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.igor.appinovatec.views.AppComponentes.ConteudoTelaUser

@Composable
fun TelaUser() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()

        ) {
            Spacer(modifier = Modifier)
            ConteudoTelaUser(
                "Processos em andamento",
                "1 quiz recebido"
            )
            ConteudoTelaUser(
                sectionName = "Área de treinamento",
                conteudo = "Quiz pendente - Front end"
            )
            Spacer(modifier = Modifier)
        }

    }
}


@Preview(showSystemUi = true)
@Composable
fun TelaUserPreview() {

}