package com.igor.appinovatec.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.igor.appinovatec.R
import com.igor.appinovatec.views.ui.theme.AppInovatecTheme
import kotlinx.coroutines.delay

class TelaDeCarregamento : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppInovatecTheme {
                Tela(1)
            }
        }
    }
}

@Composable
fun Tela(tela:Int, navController: NavController? = null){
    Box(
        Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.backgroundTelaSplash))
            .padding(10.dp)
    )
    {
        Box(
            Modifier
                .align(Alignment.Center))
        {
        IconTelaSplash(tela = tela)
        }
        Box(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 20.dp))
        {
            if (tela == 2) {
                LoadingAnimationApp()
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    AppInovatecTheme {
        Tela(2, )
    }
}