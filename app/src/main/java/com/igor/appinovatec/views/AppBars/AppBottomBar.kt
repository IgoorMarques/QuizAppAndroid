package com.igor.appinovatec.views.AppBars


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.igor.appinovatec.R


data class BarItem(
    val dica: String,
    val icon: ImageVector,
    val rota: String
)


@Composable
fun ScaffolBottomBar(
    itens: List<BarItem>,
    barItem: MutableState<BarItem?>,
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
        itens.forEach { item ->
            AppBarItem(itemBarItem = item,
                selected = barItem.value == item,
                onClick = { itemChange(item) }
            )
        }

    }
}

@Composable
fun AppBarItem(
    itemBarItem: BarItem,
    selected: Boolean,
    onClick: () -> Unit
) {

    Column(
        modifier = Modifier.clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = itemBarItem.icon,
            contentDescription = itemBarItem.dica,
            tint = if (selected) Color.Black else Color.White,
            modifier = Modifier
        )
        Text(text = itemBarItem.dica, color = Color.White, fontSize = 10.sp)
    }
}

