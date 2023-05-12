package com.igor.appinovatec.controllers.AppRotas

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun dataHoraAtual(): String {
    val dataHoraAtual = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
    val formattedDate = dataHoraAtual.format(formatter)
    val data = formattedDate.substring(0, 9)
    val hora = formattedDate.substring(11,19)
    return "$data às $hora"
}