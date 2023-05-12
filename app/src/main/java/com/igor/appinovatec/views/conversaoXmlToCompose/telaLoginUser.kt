package com.igor.appinovatec.views.conversaoXmlToCompose

import android.view.LayoutInflater
import android.widget.Button
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.igor.appinovatec.R

@Composable
fun TelaDeLogin(onClick: () -> Unit) {
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
}
