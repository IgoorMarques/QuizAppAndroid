package com.igor.appinovatec.views.AppScreens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.igor.appinovatec.data.bottomBarItens
import com.igor.appinovatec.views.AppBars.ScaffolBottomBar
import com.igor.appinovatec.views.AppBars.ScaffolTopBar
import com.igor.appinovatec.views.AppComponentes.telaPerfilUserComponentes.ItemTelaPerfil

@Composable
fun TelaPerfilUser() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Spacer(modifier = Modifier)
        Text(
            text = "Dados Pessoais",
            modifier = Modifier.padding(start = 5.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        ItemTelaPerfil("Nome", "Igor Marques da Costa")
        ItemTelaPerfil("Endereço", "Parque Dez, Manaus - AM")
        ItemTelaPerfil("Telefone", "993243234")
        ItemTelaPerfil("Email", "igoMarques@gmail.com")
        Text(
            text = "Dados de Pagamento",
            modifier = Modifier.padding(start = 5.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        ItemTelaPerfil("Nome", "Igor Marques da Costa")
        ItemTelaPerfil("Endereço", "Parque Dez, Manaus - AM")
        ItemTelaPerfil("Telefone", "993243234")
        ItemTelaPerfil("Email", "igoMarques@gmail.com")
        Spacer(modifier = Modifier)
    }
}


@Preview(showBackground = true)
@Composable
fun TelaPerfilUserPreview() {

}
