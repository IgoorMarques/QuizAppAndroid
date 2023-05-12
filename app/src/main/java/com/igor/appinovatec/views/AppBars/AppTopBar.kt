package com.igor.appinovatec.views.AppBars

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.igor.appinovatec.R

@Composable
fun ScaffolTopBar(
    barItem: BarItem,
    itemChange: (BarItem) -> Unit = {}
) {
    Row(
        Modifier
            .background(colorResource(id = R.color.backgroundTelaSplash))
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "SKILLSTER",
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.componentsColors),
            fontSize = 20.sp
        )
        AppBarItem(itemBarItem = barItem, selected = false,
            onClick = { itemChange(barItem) })
    }
}
