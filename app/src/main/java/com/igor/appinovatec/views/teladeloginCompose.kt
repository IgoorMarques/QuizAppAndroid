package com.igor.appinovatec.views

import android.view.LayoutInflater
import android.widget.Button
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.igor.appinovatec.R


@Composable
fun TelaDeLogin(navController: NavController? = null) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                LayoutInflater.from(context).inflate(R.layout.activity_tela_cadastro_usuario, null)
            },
            update = { view ->
                view.findViewById<Button>(R.id.btEntrar).setOnClickListener {
                    navController?.navigate("otherScreen")
                }
            }
        )
    }

@Composable
fun TelaDeSelecaoUserHR(navController: NavController? = null) {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            LayoutInflater.from(context).inflate(R.layout.activity_tele_de_selecao_user_rh, null)
        },
        update = { view ->
            view.findViewById<Button>(R.id.bt_usuario).setOnClickListener {
                navController?.navigate("telaDeLogin")
            }
        }
    )
}

@Preview
@Composable
fun ver() {
    TelaDeSelecaoUserHR()
}
