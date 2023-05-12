package com.igor.appinovatec.views.AppComponentes.telaPerfilUserComponentes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.igor.appinovatec.R

@Composable
fun ItemTelaPerfil(tipoDado: String, valorDado: String) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        Spacer(modifier = Modifier)
        Text(text = tipoDado, modifier = Modifier.padding(start = 10.dp, top = 10.dp))
        Card(
            shape = RoundedCornerShape(100),
            backgroundColor = colorResource(id = R.color.componentsColors),
            modifier = Modifier.padding(end = 10.dp)
        ) {
            Text(
                text = valorDado, modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            )
        }
    }
}
