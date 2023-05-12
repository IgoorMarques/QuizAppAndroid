package com.igor.appinovatec.views.AppComponentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ConteudoTelaUser(sectionName: String, conteudo: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = sectionName,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 6.dp, top = 6.dp, bottom = 6.dp),
            textAlign = TextAlign.Start,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 30.dp, end = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TelaUserItem(conteudo)
            TelaUserItem(conteudo)
            TelaUserItem(conteudo)
            TelaUserItem(conteudo)
            TelaUserItem(conteudo)
            TelaUserItem(conteudo)
            TelaUserItem(conteudo)
            TelaUserItem(conteudo)
            TelaUserItem(conteudo)
            TelaUserItem(conteudo)
            TelaUserItem(conteudo)
            TelaUserItem(conteudo)

        }
    }
}