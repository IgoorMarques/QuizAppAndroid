package com.igor.appinovatec.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import com.igor.appinovatec.R
import com.igor.appinovatec.model.QuizItem
import com.igor.appinovatec.model.TelaConfigButton
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

val btLevelTelaConfig = listOf(
    TelaConfigButton(
        name = "Junior"
    ),
    TelaConfigButton(
        name = "Pleno"
    ),
    TelaConfigButton(
        name = "Senior"
    )
)

val btQtdQuestoesTelaConfig = listOf(
    TelaConfigButton(
        name = "10"
    ),
    TelaConfigButton(
        name = "20"
    ),
    TelaConfigButton(
        name = "30"
    )
)

val btTempoTelaConfig = listOf(
    TelaConfigButton(
        name = "10"
    ),
    TelaConfigButton(
        name = "15"
    ),
    TelaConfigButton(
        name = "20"
    )
)

val btQuizConfig = listOf(
    TelaConfigButton(
        name = "Agora"
    ),
    TelaConfigButton(
        name = "Depois"
    )
)


val menuMainScreenItens = listOf(
    ItemMenuMainScreen(
        "Treinamento",
        AppRotas.HOME_emAndamento
    ),
    ItemMenuMainScreen(
        "Recebido",
        AppRotas.HOME_PENDENTE
    ),
    ItemMenuMainScreen(
        "Historico",
        AppRotas.HOME_HISTORICO
    )
)


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