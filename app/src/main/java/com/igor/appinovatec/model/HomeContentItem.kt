package com.igor.appinovatec.model

data class HomeContentItem(
    val id: String = "datascience",
    val title: String,
    val assunto: String,
    val quizStatus: String,
    val data: String,
    val rota: String = "perguntasScreen",
    val bt_action:String = "Continuar",
    val quizTpo: String = "Em andamento"
)
