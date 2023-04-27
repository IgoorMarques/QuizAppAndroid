package com.igor.appinovatec.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.igor.appinovatec.views.ui.theme.AppInovatecTheme
import kotlinx.coroutines.delay

class rotas : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppInovatecTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "telaSplash"){
                    composable("telaSplash"){
                        Tela(2, navController)
                        LaunchedEffect(true){
                            delay(3000L)
                            navController.navigate("telaDeSelecao")
                        }
                    }
                    composable("telaDeSelecao"){
                        TelaDeSelecaoUserHR(navController)
                    }
                    composable(
                        route = "telaDeLogin"
                    ){
                        TelaDeLogin(navController)
                    }
                }
            }
        }
    }
}
