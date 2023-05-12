package com.igor.appinovatec.model

import com.igor.appinovatec.data.AllQuiz

data class QuizQuestion(
    val questao:String,
    val alternativas: List<String>,
    val alternativaCorreta:String
)

data class QuizItem(
    val id: String = "datascience",
    val image: Int,
    val nome: String
)

class QuizQuestions(
    val id: String,
    val assunto: String,
    val timePorQuestao: Int = 0,
    val qtdQuestoes: Int,
    val alternativasSelecionadas: Array<String>? = null,
    val infoQuiz: HomeContentItem? = null
) {
    fun questoes(): List<QuizQuestion>? {
        return AllQuiz[id]
    }


}