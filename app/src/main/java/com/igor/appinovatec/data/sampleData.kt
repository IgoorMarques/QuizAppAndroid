package com.igor.appinovatec.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import com.igor.appinovatec.R
import com.igor.appinovatec.model.HomeContentItem
import com.igor.appinovatec.model.QuizItem
import com.igor.appinovatec.views.AppBars.BarItem
import com.igor.appinovatec.views.AppScreens.ItemMenuMainScreen


val bottomBarItens = listOf(
    BarItem(
        dica = "Home",
        icon = Icons.Rounded.Home,
        rota = AppRotas.HOME_USER
    ),
    BarItem(
        dica = "Quiz",
        icon = Icons.Rounded.Add,
        rota = AppRotas.NOVO_QUIZ_SCREEN
    ),
    BarItem(
        dica = "Perfil",
        icon = Icons.Rounded.Person,
        rota = AppRotas.TELA_PERFIL_USER
    ),
    BarItem(
        dica = "Sair",
        icon = Icons.Rounded.ExitToApp,
        rota = AppRotas.SAIR_DO_APP
    )
)


val menuMainScreenItens = listOf(
    ItemMenuMainScreen(
        "Treinamento",
        "pendenteScreen"
    ),
    ItemMenuMainScreen(
        "Recebido",
        "emAndamentoScreen"
    ),
    ItemMenuMainScreen(
        "Historico",
        "historicoScreen"
    )
)

val menuEmAndamentoItens = listOf<HomeContentItem>()

val menuConcluidoItens = listOf<HomeContentItem>()

val menuPendenteItens = listOf<HomeContentItem>()

val areasQuiz = listOf(
    QuizItem(
        id = "datascience",
        image = R.drawable.data,
        nome = "Data Science"
    ),
    QuizItem(
        id = "machinelearning",
        image = R.drawable.artificial_intelligence,
        nome = "Machine Learning"
    ),
    QuizItem(
        id = "frontend",
        image = R.drawable.programming,
        nome = "Front End"
    ),
    QuizItem(
        id = "engsoftware",
        image = R.drawable.development,
        nome = "Eng. Software"
    ),
    QuizItem(
        id = "mobile",
        image = R.drawable.mobile_development,
        nome = "Dev Mobile"
    ),
    QuizItem(
        id = "bi",
        image = R.drawable.bi,
        nome = "Business Intelligence"
    ),
    QuizItem(
        id = "backend",
        image = R.drawable.backend,
        nome = "Backend"
    ),
    QuizItem(
        id = "dataanalytics",
        image = R.drawable.bar_chart,
        nome = "Data & Analytics"
    )
)