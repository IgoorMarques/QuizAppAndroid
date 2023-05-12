package com.igor.appinovatec.views.AppScreens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.RadioButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.igor.appinovatec.R
import com.igor.appinovatec.ui.theme.AppInovatecTheme

class telaSplash : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppInovatecTheme {
                IconTelaSplash()

            }
        }
    }
}


@Composable
fun IconTelaSplash() {
    Surface(
        shape = CircleShape,
        modifier = Modifier
            .background(color = colorResource(id = R.color.backgroundTelaSplash))
            .width(300.dp)
            .height(300.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Surface(shape = CircleShape) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)

                ) {
                    Surface(shape = CircleShape, modifier = Modifier.align(Center)) {

                        Box(
                            modifier = Modifier
                                .width(200.dp)
                                .height(200.dp)
                                .background(color = colorResource(id = R.color.backgroundTelaSplash))
                        ) {
                            Surface(shape = CircleShape, modifier = Modifier.align(Center)) {
                                Box(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(100.dp)
                                        .background(Color.White),
                                    Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.checklist),
                                        contentDescription = null
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppInovatecTheme {
        IconTelaSplash()
    }
}