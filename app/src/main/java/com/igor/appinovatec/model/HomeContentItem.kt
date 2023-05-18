package com.igor.appinovatec.model

import com.igor.appinovatec.data.AppRotas

data class HomeContentItem(
    val id: String = "datascience",
    val title: String,
    val assunto: String,
    val quizStatus: String,
    val data: String,
    val rota: String = AppRotas.HOME_emAndamento,
    val bt_action:String = "Continuar",
    val quizTpo: String = "Em andamento"
)
