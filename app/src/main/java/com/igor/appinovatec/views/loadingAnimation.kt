package com.igor.appinovatec.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.igor.appinovatec.R
import com.igor.appinovatec.views.ui.theme.AppInovatecTheme
import kotlinx.coroutines.delay

class LoadingAnimation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoadingAnimationApp()
        }
    }
}

@Composable
fun LoadingAnimationApp(
    circleSize: Dp = 25.dp,
    spaceBetween: Dp = 10.dp,
    travelDistance: Dp = 20.dp
) {
    val circulos = listOf(
        remember {
            androidx.compose.animation.core.Animatable(initialValue = 0f)
        },
        remember {
            androidx.compose.animation.core.Animatable(initialValue = 0f)
        },
        remember {
            androidx.compose.animation.core.Animatable(initialValue = 0f)
        }
    )
    circulos.forEachIndexed { index, animatable ->
        LaunchedEffect(key1 = animatable) {
            delay(index * 100L)
            animatable.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = 1200
                        0.0f at 0 with LinearOutSlowInEasing
                        1.0f at 300 with LinearOutSlowInEasing
                        0.0f at 600 with LinearOutSlowInEasing
                        0.0f at 1200 with LinearOutSlowInEasing
                    },
                    repeatMode = RepeatMode.Restart
                )
            )
        }
    }

    val circleValues = circulos.map { it.value }
    val distance = with(LocalDensity.current) { travelDistance.toPx() }
    val ultimoCirculo = circleValues.size - 1

    Row(
        Modifier
            .background(colorResource(id = R.color.backgroundTelaSplash))) {
        circleValues.forEachIndexed { index, value ->
            Box(modifier = Modifier
                .size(circleSize)
                .graphicsLayer {
                    translationY = -value * distance
                }
                .background(Color.White, shape = CircleShape)

            )
            if (index != ultimoCirculo) {
                Spacer(modifier = Modifier.width(spaceBetween))
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    AppInovatecTheme {
        LoadingAnimationApp()
    }
}