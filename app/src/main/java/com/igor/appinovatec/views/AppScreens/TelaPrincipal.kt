package com.igor.appinovatec.views.AppScreens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.igor.appinovatec.R
import com.igor.appinovatec.data.menuMainScreenItens
import com.igor.appinovatec.model.HomeContentItem
import com.igor.appinovatec.views.ui.theme.Teal200
import com.igor.appinovatec.views.ui.theme.backgroundItemQuiz
import com.igor.appinovatec.views.ui.theme.thinColor


data class ItemMenuMainScreen(
    val title: String,
    val rota: String
)


@Composable
fun TelaPrincipal(
    menuItemSelected: ItemMenuMainScreen,
    onMenuItemSelectedChange: (ItemMenuMainScreen) -> Unit = {},
    content: @Composable () -> Unit

) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Menu(
                itens = menuMainScreenItens,
                menuItem = menuItemSelected,
                itemChange = onMenuItemSelectedChange
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Spacer(modifier = Modifier)
                content()
                Spacer(modifier = Modifier)
            }
        }
    }


}

@Composable
fun Menu(
    itens: List<ItemMenuMainScreen>,
    menuItem: ItemMenuMainScreen,
    itemChange: (ItemMenuMainScreen) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .height(50.dp)
            .padding(6.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            itens.forEach { item ->
                MenuTelaPrincipalItem(menuItem = item,
                    selected = menuItem == item,
                    onClick = { itemChange(item) }
                )
            }
        }
    }
}


@Composable
fun MenuTelaPrincipalItem(
    menuItem: ItemMenuMainScreen,
    selected: Boolean,
    onClick: () -> Unit
) {
    var color = Color.White
    if (selected) {
        color = Color.Black
    }

    Surface(shape = RoundedCornerShape(10)) {
        Column(
            modifier = Modifier.clickable(onClick = onClick),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(
                text = menuItem.title,
                fontSize = 16.sp,
            )
            Box(
                modifier = Modifier
                    .background(
                        color = color,
                        shape = RoundedCornerShape(
                            bottomStart = 20.dp,
                            bottomEnd = 20.dp
                        )
                    )
                    .width(100.dp)
                    .height(4.dp)
            )
        }
    }
}


@Composable
fun TelaItem(
    item: HomeContentItem,
    onClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        elevation = 6.dp
    )
    {
        Column(
            modifier = Modifier
                .background(backgroundItemQuiz),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = item.data, fontSize = 12.sp, fontWeight = FontWeight.W500,
                color = thinColor,
                modifier = Modifier.fillMaxWidth().padding(end = 5.dp),
                textAlign = TextAlign.End
            )
            Row(
                Modifier.fillMaxWidth()
                    .padding(start = 15.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.size(80.dp)) {
                    item.item?.let { painterResource(it.image) }?.let {
                        Image(
                            painter = it,
                            contentDescription = "IMG BACKGROUND"
                        )
                    }
                }
                Column(horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(start = 20.dp)) {
                    Text(
                        text = item.title, fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(text = item.assunto)
                    Text(text = item.quizStatus, fontSize = 14.sp,)
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 1.dp),
                horizontalArrangement = Arrangement.End

            ) {

                Row(modifier = Modifier.padding(end = 5.dp, bottom = 5.dp)) {
                    Surface(
                        shape = RoundedCornerShape(100),
                        elevation = 6.dp
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.30f)
                                .background(Teal200)
                                .clickable { onClick() },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = item.bt_action, color = Color.White,
                                modifier = Modifier.padding(horizontal = 8.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))

                    Surface(
                        shape = RoundedCornerShape(100),
                        elevation = 6.dp
                    ) {
                        Box(
                            modifier = Modifier
                                .clickable { onDeleteClick() }
                                .background(Color.Red)
                        ) {
                            Text(
                                text = "Descartar", color = Color.White,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}


