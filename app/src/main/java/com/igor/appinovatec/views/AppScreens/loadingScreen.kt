package com.igor.appinovatec.views.AppScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.igor.appinovatec.R
import com.igor.appinovatec.views.AppAnimations.LoadingAnimationApp

@Composable
fun TelaDeCarregamento() {
    Box(
        Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.backgroundTelaSplash))
            .padding(10.dp)
    )
    {
        Box(
            Modifier
                .align(Alignment.Center)
        )
        {
            IconTelaSplash()
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
        )
        {
            LoadingAnimationApp()
        }

    }
}